package com.demo.dao;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.demo.beans.Product;

public class ProductDaoImpl implements ProductDao{
	static Connection con;
	static PreparedStatement pstat, pdel, pupdate, pselect, pfindbyid, psortedbyname;
	static {
		try {
			con = DBUtil.getMyConnection();
			pstat = con.prepareStatement("insert into product values(?, ?, ?, ?, ?, ?)");
			pdel = con.prepareStatement("delete from product where pid=?");
			pupdate = con.prepareStatement("update product set qty=?, price=? where pid=?");
			pselect = con.prepareStatement("select * from product");
			pfindbyid = con.prepareStatement("select * from product where pid=?");
			psortedbyname = con.prepareStatement("select * from product order by pname");
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	@Override
	public boolean save(Product p) {
		try {
			pstat.setInt(1, p.getPid());
			pstat.setString(2, p.getPname());
			pstat.setInt(3, p.getQty());
			pstat.setDouble(4, p.getPrice());
			pstat.setDate(5, Date.valueOf(p.getExpdate()));
			pstat.setInt(6, p.getCid());
			int res = pstat.executeUpdate();
			if(res>0) {
				return true;
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return false;
	}

	@Override
	public boolean deleteById(int pid) {
		try {
			pdel.setInt(1, pid);
			int n = pdel.executeUpdate();
			if(n>0) {
				return true;
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return false;
	}

	@Override
	public boolean updateById(int pid, int qty, double price) {
		try {
			pupdate.setInt(1, qty);
			pupdate.setDouble(2, price);
			pupdate.setInt(3, pid);
			int r = pupdate.executeUpdate();
			if(r>0) {
				return true;
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return false;
	}

	@Override
	public List<Product> findAllProducts() {
		List<Product> plst = new ArrayList<Product>();
		try {
			ResultSet rs = pselect.executeQuery();
			while(rs.next()) {
				Product p = new Product(rs.getInt(1), rs.getString(2), rs.getInt(3), rs.getDouble(4), rs.getDate(5).toLocalDate(), rs.getInt(6));
				plst.add(p);
			}
			if(plst.size()>0) {
				return plst;
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return null;
	}

	@Override
	public Product findById(int pid) {
		try {
			pfindbyid.setInt(1, pid);
			ResultSet rs = pfindbyid.executeQuery();
			if(rs.next()) {
				return new Product(rs.getInt(1), rs.getString(2), rs.getInt(3), rs.getDouble(4), rs.getDate(5).toLocalDate(), rs.getInt(6));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return null;
	}

	@Override
	public List<Product> getSortedByName() {
		List<Product>plst = new ArrayList<Product>();
		try {
			ResultSet rs = psortedbyname.executeQuery();
			while(rs.next()) {
				Product p = new Product(rs.getInt(1), rs.getString(2), rs.getInt(3), rs.getDouble(4), rs.getDate(5).toLocalDate(), rs.getInt(6));
				plst.add(p);
			}
			if(plst.size()>0) {
				return plst;
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return null;
	}

	@Override
	public void closeConnection() {
		DBUtil.closeMyConnection();
	}

}
