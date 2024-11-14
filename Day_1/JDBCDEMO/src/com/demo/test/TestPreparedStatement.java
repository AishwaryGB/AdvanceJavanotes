package com.demo.test;

import java.sql.Connection;
import java.sql.Date;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDate;

public class TestPreparedStatement {

	public static void main(String[] args) {
		Connection conn=null;
		try {
			DriverManager.registerDriver(new com.mysql.cj.jdbc.Driver());
			String url="jdbc:mysql://localhost:3306/test?useSSL=false";
			 conn=DriverManager.getConnection(url,"root","root123");
			PreparedStatement pst=conn.prepareStatement("select * from product");
			ResultSet rs=pst.executeQuery();
			while(rs.next()) {
				System.out.println("PID : "+rs.getInt(1));
				System.out.println("Name : "+rs.getString(2));
				System.out.println("Qty : "+rs.getInt(3));
				System.out.println("Price : "+rs.getDouble(4));
				System.out.println("expiry date : "+rs.getDate(5));
				System.out.println("CID : "+rs.getInt(6));
				System.out.println("-------------------------");
			}
			int pid=14;
			String pname="biscuits2222";
			int qty=50;
			double price=44.56;
			LocalDate dt=LocalDate.of(2025,03,02);
			java.sql.Date sdt=Date.valueOf(dt);
			int cid=1;
			PreparedStatement pst1=conn.prepareStatement("insert into product values(?,?,?,?,?,?)");
			pst1.setInt(1, pid);
			pst1.setString(2, pname);
			pst1.setInt(3, qty);
			pst1.setDouble(4, price);
			pst1.setDate(5,sdt);
			pst1.setInt(6, cid);
			int n=pst1.executeUpdate();
			if(n>0) {
				System.out.println("insertion done");
			}
			else {
				System.out.println("error occured");
			}
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		try {
			conn.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		

	}

}
