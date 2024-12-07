package com.demo.test;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

import com.demo.beans.Customer;
import com.demo.beans.Employee;

public class TestRetrieveData {

	public static void main(String[] args) {
		SessionFactory sf=new Configuration().configure().buildSessionFactory();
		
		Session sess=sf.openSession();
		Transaction tr=sess.beginTransaction();
		Employee e1=sess.get(Employee.class,12);
		System.out.println(e1);
		Customer c1=sess.get(Customer.class,13);
		System.out.println(c1);
		tr.commit();
		sess.close();
		sf.close();

	}

}
