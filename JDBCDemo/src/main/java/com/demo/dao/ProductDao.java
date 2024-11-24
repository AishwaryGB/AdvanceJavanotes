package com.demo.dao;

import java.util.List;

import com.demo.beans.Product;

public interface ProductDao {

	boolean save(Product p);

	boolean deleteById(int pid);

	boolean updateById(int pid, int qty, double price);

	List<Product> findAllProducts();

	Product findById(int pid);

	List<Product> getSortedByName();

	void closeConnection();

}
