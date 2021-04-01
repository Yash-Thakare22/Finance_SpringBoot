package com.lti.services;

import java.util.List;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.lti.bean.Product;
import com.lti.dao.ProductDao;
import com.lti.exceptions.HrExceptions;

@Service
public class ProductServiceImpl implements ProductService{

	@Autowired
	private ProductDao dao;
	
	@Transactional(propagation=Propagation.REQUIRES_NEW)
	@Override
	public boolean addProduct(Product p) throws HrExceptions {
		return dao.addProduct(p);
	}

	@Override
	public List<Product> displayProduct() throws HrExceptions {
		return dao.displayProduct();
	}

	@Transactional(propagation=Propagation.REQUIRES_NEW)
	@Override
	public void deleteProduct(int id) throws HrExceptions {
		dao.deleteProduct(id);	
	}

	@Override
	public Product getProdById(int id) {
		return dao.getProdById(id);
	}

	@Transactional(propagation=Propagation.REQUIRES_NEW)
	@Override
	public boolean updateProduct(int id, Product p) throws HrExceptions {
		return dao.updateProduct(id, p);
		
	}
	
	

}
