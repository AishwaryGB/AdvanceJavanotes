package com.demo.service;

import java.util.List;

import com.demo.beans.Product;
import com.demo.dao.ProductDao;
import com.demo.dao.ProductDaoImpl;

public class ProductServiceImpl implements ProductService{
  private ProductDao pdao;

public ProductServiceImpl() {
	super();
	this.pdao = new ProductDaoImpl();
}

@Override
public List<Product> getAllProducts() {
	return pdao.findAllProducts();
}

@Override
public boolean insertProduct(Product p) {
	return pdao.saveProduct(p);
}

@Override
public boolean deletById(int pid) {
	return pdao.removeById(pid);
}

@Override
public Product getById(int pid) {
	return pdao.findById(pid);
}

@Override
public boolean updateProduct(Product p) {
	return pdao.modifyProduct(p);
}
  
}
