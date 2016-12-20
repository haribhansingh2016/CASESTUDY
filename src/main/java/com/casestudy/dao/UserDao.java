package com.casestudy.dao;

import com.casestudy.model.User;

public interface UserDao {
	
	public User findByEmail(String email);
	

}
