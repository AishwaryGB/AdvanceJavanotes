package com.demo.dao;

import com.demo.beans.MyUSer;

public interface LoginDao {

	MyUSer authenticateUSer(String uname, String passwd);

}
