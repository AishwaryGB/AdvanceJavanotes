package com.demo.test;



import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;
import org.hibernate.criterion.Criterion;
import org.hibernate.criterion.LogicalExpression;
import org.hibernate.criterion.Restrictions;

import com.demo.beans.Product;

public class TestCriteriaQuery {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		SessionFactory sf=new Configuration().configure().buildSessionFactory();
		Session sess=sf.openSession();
		Transaction tr=sess.beginTransaction();
		Criteria cr=sess.createCriteria(Product.class);
		List<Product> plist=cr.list();
		plist.forEach(System.out::println);
		Criterion cr1=Restrictions.gt("price", 2000.0f);
		Criterion cr2=Restrictions.gt("qty", 35);
		Criteria cr3=sess.createCriteria(Product.class);
		//select * from product where price>2000 or qty>35
		LogicalExpression expr=Restrictions.or(cr1,cr2);
		
		cr3.add(expr);
		List<Product> plist1=cr3.list();
		plist1.forEach(System.out::println);
    		
		//select * from product where price>1000 and price< 300 or qty<40
		Criteria cr11=sess.createCriteria(Product.class);
		Criterion cr12=Restrictions.gt("price", 1000f);
		Criterion cr13=Restrictions.lt("price", 3000f);
		Criterion cr14=Restrictions.lt("qty", 40);
		LogicalExpression expression=Restrictions.and(cr12, cr13);
		LogicalExpression expression1=Restrictions.or(expression,cr14);
		cr11.add(expression1);
		List<Product> plist11=cr11.list();
		plist11.forEach(System.out::println);
		
		tr.commit();
		sess.close();
		sf.close();
		

	}

}
