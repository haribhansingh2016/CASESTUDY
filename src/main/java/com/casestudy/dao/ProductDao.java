package com.casestudy.dao;

import java.util.List;
import com.casestudy.model.Product;



public interface ProductDao {
	List<Product> listAllProducts();
	List<Product> listProductsByCategory(String category);
	Product findById(long productId);
	List<Product> productFilter(int filterValue);
}
