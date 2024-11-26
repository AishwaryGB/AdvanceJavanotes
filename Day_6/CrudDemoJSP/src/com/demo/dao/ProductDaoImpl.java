package com.demo.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.demo.beans.Product;

public class ProductDaoImpl implements ProductDao{
	static Connection conn;
	static PreparedStatement getAll,insprod,delprod,getByID,updateprod;
	static {
		
		try {
			conn=DBUtil.getMyConnection();
			getAll=conn.prepareStatement("select * from product");
			insprod=conn.prepareStatement("insert into product values(?,?,?,?,?,?)");
			delprod=conn.prepareStatement("delete from product where pid=?");
			getByID=conn.prepareStatement("select * from product where pid=?");
			updateprod=conn.prepareStatement("update product set pname=?,qty=?,price=?,expdate=?,cid=? where pid=?");
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	@Override
	public List<Product> findAllProducts() {
		List<Product> plist=new ArrayList<>();
		try {
			ResultSet rs=getAll.executeQuery();
			while(rs.next()) {
				plist.add(new Product(rs.getInt(1),rs.getString(2),rs.getInt(3),rs.getDouble(4),rs.getDate(5).toLocalDate(),rs.getInt(6)));
			}
			if(plist.size()>0)
				return plist;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}
	@Override
	public boolean saveProduct(Product p) {
		try {
			insprod.setInt(1, p.getPid());
			insprod.setString(2, p.getPname());
			insprod.setInt(3, p.getQty());
			insprod.setDouble(4, p.getPrice());
			insprod.setDate(5, java.sql.Date.valueOf(p.getExpdate()));
			insprod.setInt(6, p.getCid());
			int n=insprod.executeUpdate();
			if(n>0)
				return true;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return false;
	}
	@Override
	public boolean removeById(int pid) {
		try {
			delprod.setInt(1, pid);
			int n=delprod.executeUpdate();
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
	public Product findById(int pid) {
		try {
			getByID.setInt(1, pid);
			ResultSet rs=getByID.executeQuery();
			if(rs.next()) {
				return new Product(rs.getInt(1),rs.getString(2),rs.getInt(3),rs.getDouble(4),rs.getDate(5).toLocalDate(),rs.getInt(6));
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}
	@Override
	public boolean modifyProduct(Product p) {
		try {
			updateprod.setString(1, p.getPname());
			updateprod.setInt(2, p.getQty());
			updateprod.setDouble(3, p.getPrice());
			updateprod.setDate(4, java.sql.Date.valueOf(p.getExpdate()));
			updateprod.setInt(5, p.getCid());
			updateprod.setInt(6, p.getPid());
			int n=updateprod.executeUpdate();
			if (n>0) {
				return true;
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return false;
	}

}
