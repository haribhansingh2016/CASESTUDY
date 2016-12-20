package com.casestudy.dao;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.criterion.Disjunction;
import org.hibernate.criterion.Restrictions;
import org.springframework.stereotype.Repository;

import com.casestudy.model.Product;

@Repository("prodcutDao")
public class ProductDaoImpl extends AbstractDao<Integer, Product> implements ProductDao{
	
	@SuppressWarnings("unchecked")
	public List<Product> listAllProducts() {
		Criteria criteria = createEntityCriteria();
		return (List<Product>) criteria.list();
	}

	public List<Product> listProductsByCategory(String category) {
		Criteria criteria = createEntityCriteria();
		criteria.add(Restrictions.eq("category",category));
		return criteria.list();
	}

	public Product findById(long productId) {
		return getByKey(productId);
	}

	public List<Product> productFilter(int filterValue) {
		Criteria criteria = createEntityCriteria();
		Disjunction disj = Restrictions.disjunction();
		if(filterValue>=8){
			filterValue-=8;
			disj.add(Restrictions.ge("price", 3000));
			
		}
		if(filterValue>=4){
			filterValue-=4;
			disj.add(Restrictions.between("price",1000, 3000));
			
		}
		if(filterValue>=2){
			disj.add(Restrictions.between("price",499,1000));
			filterValue-=2;
			
		}
		if(filterValue>=1){
			disj.add(Restrictions.le("price", 499));
			filterValue-=1;
			
		}
		criteria.add(disj);
		
		return criteria.list();
	}


}
