package com.casestudy.service;

import java.util.List;
import com.casestudy.model.Product;

public interface ProductService {

	List<Product> listAllProducts();
	List<Product> listProductsByCategory(String category);
	Product findById(long longProductId);
	List<Product> productHomePriceFilter(int filterValue);
}
