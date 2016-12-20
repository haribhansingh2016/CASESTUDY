package com.casestudy.dao;

import org.springframework.stereotype.Repository;

import com.casestudy.model.Order;
import com.casestudy.model.Product;
import com.casestudy.model.User;


@Repository("orderDao")
public class OrderDaoImpl  extends AbstractDao<Integer, Order> implements OrderDao {

	public Order createCartOrder(Product product,User user) {
		Order order = new Order();
		order.setCartUser(user);
		order.setProduct(product);
		persist(order);
		return order;
	}

}
