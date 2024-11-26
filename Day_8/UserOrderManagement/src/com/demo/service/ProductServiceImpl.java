package com.demo.service;

import java.util.List;

import com.demo.beans.Category;
import com.demo.beans.Product;
import com.demo.dao.ProductDao;
import com.demo.dao.ProductDaoImpl;

public class ProductServiceImpl implements ProductService {
	ProductDao pdao;
	public ProductServiceImpl() {
		super();
		this.pdao = new ProductDaoImpl();
	}
	@Override
	public List<Category> getAllCategory() {
		// TODO Auto-generated method stub
		return pdao.findAllCategory();
	}
	@Override
	public List<Product> getProductsBycid(int cid) {
		// TODO Auto-generated method stub
		return pdao.findProductsByCategory(cid);
	}
	@Override
	public Product getById(int pid) {
		return pdao.findById(pid);
	}

}
