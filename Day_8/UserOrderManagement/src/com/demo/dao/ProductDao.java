package com.demo.dao;

import java.util.List;

import com.demo.beans.Category;
import com.demo.beans.Product;

public interface ProductDao {

	List<Category> findAllCategory();

	List<Product> findProductsByCategory(int cid);

	Product findById(int pid);

}
