package com.casestudy.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import com.casestudy.dao.ProductDao;
import com.casestudy.model.Product;


@Service("productService")
@Transactional
public class ProductServiceImpl implements ProductService{
	
	@Autowired
	private ProductDao dao;
	
	public List<Product> listAllProducts() {
		return dao.listAllProducts();
	}

	public List<Product> listProductsByCategory(String category) {
		return dao.listProductsByCategory(category);
	}

	public Product findById(long productId) {
		return dao.findById(productId);
	}

	public List<Product> productHomePriceFilter(int filterValue) {
		return dao.productFilter(filterValue);
	}

}
