package com.casestudy.service;

import java.util.List;

import com.casestudy.model.Order;
import com.casestudy.model.User;

public interface UserService {
	
	public User findByemailId(String  emailId);
	
	public void addProductToCart(String email,long productId);
	
	public List<Order> getAllCartOrders(String email);

}
