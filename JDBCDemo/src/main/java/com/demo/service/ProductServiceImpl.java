package com.demo.service;

import com.demo.beans.Product;
import com.demo.dao.ProductDao;
import com.demo.dao.ProductDaoImpl;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.List;
import java.util.Scanner;

public class ProductServiceImpl implements ProductService{
   private ProductDao pdao;

   public ProductServiceImpl() {
	   super();
	   this.pdao = new ProductDaoImpl();
}

@Override
public boolean addProduct() {
	Scanner sc=new Scanner(System.in);
	System.out.println("enetr pid");
	int pid=sc.nextInt();
	System.out.println("Enter pname: ");
	String pname=sc.next();
	System.out.println("Enter quantity: ");
	int qty = sc.nextInt();
	System.out.println("Enter price: ");
	double price = sc.nextDouble();
	System.out.println("Enter expiry date: dd/MM/YYYY");
	String date = sc.next();
	LocalDate ldt = LocalDate.parse(date, DateTimeFormatter.ofPattern("dd/MM/YYYY"));
	System.out.println("Enter category id: ");
	int cid = sc.nextInt();
	Product p = new Product(pid, pname, qty, price, ldt, cid);
	return pdao.save(p);
}

@Override
public boolean removeById(int pid) {
	return pdao.deleteById(pid);
}

@Override
public boolean updateById(int pid, int qty, double price) {
	return pdao.updateById(pid, qty, price);
}

@Override
public List<Product> getAllProducts() {
	return pdao.findAllProducts();
}

@Override
public Product getById(int pid) {
	return pdao.findById(pid);
}

@Override
public List<Product> getSortedByName() {
	return pdao.getSortedByName();
}

@Override
public void closeMyConnection() {
	pdao.closeConnection();
}
   
}
