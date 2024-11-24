package com.demo.service;

import com.demo.beans.MyUSer;
import com.demo.dao.LoginDao;
import com.demo.dao.LoginDaoImpl;

public class LoginServiceImpl implements LoginService{
      private LoginDao ldao;

	public LoginServiceImpl() {
		super();
		this.ldao = new LoginDaoImpl();
	}

	@Override
	public MyUSer validateUser(String uname,String passwd) {
		return ldao.authenticateUSer(uname,passwd);
	}
      
}
