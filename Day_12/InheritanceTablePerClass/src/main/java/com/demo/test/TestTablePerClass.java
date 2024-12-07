package com.demo.test;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

import com.demo.beans.Customer;
import com.demo.beans.Employee;
import com.demo.beans.Person;

public class TestTablePerClass {
	public static void main(String[] args) {
		SessionFactory sf=new Configuration().configure().buildSessionFactory();
		Employee e=new Employee(121,"xxx","3333","hr","mgr");
		Customer c=new Customer(131,"yyy","4444","baner","Rajesh");
		Person p=new Person(141,"zzz","3333");
		Session sess=sf.openSession();
		Transaction tr=sess.beginTransaction();
		sess.save(e);
		sess.save(c);
		sess.save(p);
		tr.commit();
		sess.close();
		sf.close();
	}

}
