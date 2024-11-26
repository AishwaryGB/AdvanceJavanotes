package com.demo.service;

import java.util.List;

import com.demo.beans.Product;

public interface ProductService {

	List<Product> getAllProducts();

	boolean insertProduct(Product p);

	boolean deletById(int pid);

	Product getById(int pid);

	boolean updateProduct(Product p);

}
