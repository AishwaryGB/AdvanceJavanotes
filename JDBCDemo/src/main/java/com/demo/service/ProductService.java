package com.demo.service;

import java.util.List;

import com.demo.beans.Product;

public interface ProductService {

	boolean addProduct();

	boolean removeById(int pid);

	boolean updateById(int pid, int qty, double price);

	List<Product> getAllProducts();

	Product getById(int pid);

	List<Product> getSortedByName();

	void closeMyConnection();

}
