package com.demo.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.demo.beans.MyUSer;

public class LoginDaoImpl implements LoginDao{
	private static Connection conn;
	private static PreparedStatement selUser;
	static {
		
		try {
			conn=DBUtil.getMyConnection();
			selUser=conn.prepareStatement("select uname, passwd,role from user where uname=? and passwd=?");
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}

	@Override
	public MyUSer authenticateUSer(String uname, String passwd) {
		try {
			selUser.setString(1, uname);
			selUser.setString(2, passwd);
			ResultSet rs=selUser.executeQuery();
			if(rs.next()) {
				return new MyUSer(rs.getString(1),rs.getString(2),rs.getString(3));
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return null;
	}

}
