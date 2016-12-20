package com.casestudy.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.casestudy.dao.OrderDao;
import com.casestudy.dao.ProductDao;
import com.casestudy.dao.UserDao;
import com.casestudy.model.Order;
import com.casestudy.model.Product;
import com.casestudy.model.User;

@Service("userService")
@Transactional
public class UserServiceImpl implements UserService {
	
	@Autowired
	UserDao dao;
	
	@Autowired
	ProductDao productDao;
	
	@Autowired
	OrderDao orderDao;
	
	public User findByemailId(String emailId) {
		// TODO Auto-generated method stub
		return dao.findByEmail(emailId);
	}

	public void addProductToCart(String email, long productId) {
		User user = dao.findByEmail(email);
		Product product = productDao.findById(productId);
		Order order = orderDao.createCartOrder(product, user);
		user.getListOfOrdersCart().add(order);
	}
	
	public List<Order> getAllCartOrders(String email){
		User user = dao.findByEmail(email);
		return (List<Order>) user.getListOfOrdersCart();
	}
	
	

}
