package com.lti.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import org.springframework.stereotype.Repository;

import com.lti.bean.Consumer;
import com.lti.bean.Product;
import com.lti.bean.Transaction;
import com.lti.exceptions.HrExceptions;

@Repository
public class TransactionDaoImpl implements TransactionDao{

	@PersistenceContext
	private EntityManager manager;

	@Override
	public boolean addTransaction(int cid, int pid, Transaction t) throws HrExceptions {
		Product p=manager.find(Product.class, pid);
		t.setProduct(p);
		Consumer c=manager.find(Consumer.class, cid);
		t.setConsumer(c);
		manager.persist(t);
		return true;	
	}

	@Override
	public List<Transaction> displayTransaction(long cardNo) throws HrExceptions {
		String strQry ="Select t from Transaction t where t.cardNumber =: card";
		Query qry = manager.createQuery(strQry);
		qry.setParameter("card", cardNo);
		List<Transaction> list=qry.getResultList();
		return (List<Transaction>) list ;
	}
	

}
