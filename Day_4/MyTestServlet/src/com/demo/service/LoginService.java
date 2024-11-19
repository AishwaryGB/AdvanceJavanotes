package com.demo.service;

import com.demo.beans.MyUser;
import com.demo.beans.Person;

public interface LoginService {

	MyUser validateUser(String uname, String passwd);

	boolean registerdetails(Person p1, MyUser u1);

}
