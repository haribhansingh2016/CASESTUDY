package com.casestudy.dao;

import com.casestudy.model.Order;
import com.casestudy.model.Product;
import com.casestudy.model.User;

public interface OrderDao {
	public Order createCartOrder(Product product,User user);
}
