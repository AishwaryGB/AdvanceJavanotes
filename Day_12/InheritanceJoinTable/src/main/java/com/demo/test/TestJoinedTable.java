package com.demo.test;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

import com.demo.beans.Customer;
import com.demo.beans.Employee;

public class TestJoinedTable {
	public static void main(String[] args) {
		SessionFactory sf=new Configuration().configure().buildSessionFactory();
		Employee e=new Employee(12,"Raj","3333","hr","mgr");
		Customer c=new Customer(13,"Devinder","4444","baner","Rajesh");
		Session sess=sf.openSession();
		Transaction tr=sess.beginTransaction();
		sess.save(e);
		sess.save(c);
		tr.commit();
		sess.close();
		sf.close();
	}

}
