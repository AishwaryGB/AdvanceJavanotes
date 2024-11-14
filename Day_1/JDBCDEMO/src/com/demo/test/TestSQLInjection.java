package com.demo.test;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.time.LocalDate;

public class TestSQLInjection {

	public static void main(String[] args) {
		try {
			//step 1: register driver
			DriverManager.registerDriver(new com.mysql.cj.jdbc.Driver());
			//step 2: get connection
			String url="jdbc:mysql://localhost:3306/test";
			Connection conn=DriverManager.getConnection(url,"root","root123");
			//step 3 create a statement
			Statement st=conn.createStatement();
			String user="yyy";
			String password="xxx' or '1'='1";
			String query="select * from user where uname='"+user+"' and password='"+password+"'";
			System.out.println(query);
			ResultSet rs=st.executeQuery(query);
			while(rs.next()) {
				System.out.println("User : "+rs.getString(1));
				System.out.println("Password : "+rs.getString(2));
				System.out.println("role : "+rs.getString(3));
				System.out.println("-----------");
			}
					
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

}
