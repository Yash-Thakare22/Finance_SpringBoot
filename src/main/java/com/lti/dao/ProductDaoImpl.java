package com.lti.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import org.springframework.stereotype.Repository;

import com.lti.bean.Product;
import com.lti.exceptions.HrExceptions;

@Repository
public class ProductDaoImpl implements ProductDao{

	@PersistenceContext
	private EntityManager manager;
	
	@Override
	public boolean addProduct(Product p) throws HrExceptions {
		manager.persist(p);
		return true;

	}

	@Override
	public List<Product> displayProduct() throws HrExceptions {
		String strQry ="from Product";
		Query qry = manager.createQuery(strQry);
		List<Product> list=qry.getResultList();
		return (List<Product>) list ;
	}

	@Override
	public void deleteProduct(int id) throws HrExceptions {
		Product temp= manager.find(Product.class,id);
		manager.remove(temp);
	}

	@Override
	public Product getProdById(int id) {
		Product prd = manager.find(Product.class, id);
		return prd;

	}

	@Override
	public boolean updateProduct(int id, Product p) throws HrExceptions 
	{
		manager.merge(p);
		return true;		
	}

}
