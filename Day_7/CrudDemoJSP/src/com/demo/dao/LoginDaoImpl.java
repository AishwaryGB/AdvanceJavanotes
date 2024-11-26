package com.demo.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.demo.beans.MyUser;
import com.demo.beans.Person;

public class LoginDaoImpl implements LoginDao{
	static Connection conn;
	static PreparedStatement seluser,adduser,sdetails;
	static {
		
		try {
			conn=DBUtil.getMyConnection();
			seluser=conn.prepareStatement("select uname,password,role from user where uname=? and password=?");
			adduser=conn.prepareStatement("insert into user(uname,password,role) values(?,?,?)");
			sdetails=conn.prepareStatement("insert into person(fname,lname,gender,degree,city,skills) values(?,?,?,?,?,?)");	
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	@Override
	public MyUser authenticateUSer(String uname, String passwd) {
		try {
			seluser.setString(1, uname);
			seluser.setString(2, passwd);
			ResultSet rs=seluser.executeQuery();
			if(rs.next()) {
				return new MyUser(rs.getString(1),rs.getString(2),rs.getString(3));
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
		
	}

	@Override
	public boolean savedetails(Person p1, MyUser u1) {
		try {
			conn.setAutoCommit(false);
			System.out.println(u1.getUname()+"------"+u1.getPasswd());
			adduser.setString(1, u1.getUname());
			adduser.setString(2,u1.getPasswd());
			adduser.setString(3,u1.getRole());
			adduser.executeUpdate();
			sdetails.setString(1, p1.getFname());
			sdetails.setString(2, p1.getLname());
			sdetails.setString(3, p1.getGender());
			sdetails.setString(4, p1.getDegree());
			sdetails.setString(5, p1.getCity());
			sdetails.setString(6,String.join(",",p1.getSkills()) );
			sdetails.executeUpdate();
			conn.commit();
			
			return true;
			
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			try {
				conn.rollback();
				
			} catch (SQLException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
			e.printStackTrace();
		}finally {
			try {
				conn.setAutoCommit(true);
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		
		return false;
	}

}
