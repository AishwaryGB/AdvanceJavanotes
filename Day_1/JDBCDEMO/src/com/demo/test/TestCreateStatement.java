package com.demo.test;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.time.LocalDate;

public class TestCreateStatement {

	public static void main(String[] args) {
		try {
			//step 1: register driver
			DriverManager.registerDriver(new com.mysql.cj.jdbc.Driver());
			//step 2: get connection
			String url="jdbc:mysql://localhost:3306/test";
			Connection conn=DriverManager.getConnection(url,"root","root123");
			//step 3 create a statement
			Statement st=conn.createStatement();
			ResultSet rs=st.executeQuery("select * from product");
			//step 4 navigate through resultset
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
			String pname="biscuits";
			int qty=34;
			double price=34.56;
			LocalDate dt=LocalDate.of(2025,02,02);
			int cid=1;
			String query="insert into product values("+pid+",'"+pname+"',"+qty+","+price+",'"+dt+"',"+cid+")";
			System.out.println(query);
			int n=st.executeUpdate(query);
			if(n>0)
			   System.out.println("insertion done!!");
			else
				System.out.println("error occured");
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

}
