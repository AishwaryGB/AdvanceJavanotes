package com.demo.test;



import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

import com.demo.beans.Product;

public class TestProduct {
	public static void main(String[] args) {
		SessionFactory sf=new Configuration().configure().buildSessionFactory();
		Product p1=new Product(12,"chair",45,1500);
		Product p2=new Product(13,"table",10,2500);
		Product p3=new Product(14,"shelf",45,3500);
		Product p4=new Product(15,"sofa chair",5,1500);
		Session sess=sf.openSession();
		Transaction tr=sess.beginTransaction();
		sess.save(p1);
		sess.save(p2);
		sess.save(p3);
		sess.save(p4);
		
		
		tr.commit();
		sess.close();
		sf.close();
	}

}
