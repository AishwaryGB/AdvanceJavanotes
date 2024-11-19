package com.demo.dao;

import com.demo.beans.MyUser;
import com.demo.beans.Person;

public interface LoginDao {

	MyUser authenticateUSer(String uname, String passwd);

	boolean savedetails(Person p1, MyUser u1);

}
