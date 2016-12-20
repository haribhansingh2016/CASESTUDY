package com.casestudy.dao;

import org.hibernate.Criteria;
import org.hibernate.criterion.Restrictions;
import org.springframework.stereotype.Repository;

import com.casestudy.model.User;

@Repository("userDao")
public class UserDaoImpl extends AbstractDao<Integer, User> implements UserDao {

	public User findByEmail(String email) {
		Criteria criteria = createEntityCriteria();
		criteria.add(Restrictions.eq("emailId", email));
		return (User) criteria.uniqueResult();
	}


	

}
