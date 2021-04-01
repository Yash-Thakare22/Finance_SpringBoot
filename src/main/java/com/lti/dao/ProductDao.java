package com.lti.dao;



import java.util.List;

import com.lti.bean.Product;
import com.lti.exceptions.HrExceptions;

public interface ProductDao {
	
	public boolean addProduct(Product p) throws HrExceptions;
    public void deleteProduct(int id) throws HrExceptions;
    public boolean updateProduct(int id,Product p) throws HrExceptions;
    public List<Product> displayProduct() throws HrExceptions;
    public Product getProdById(int id);
    

}
