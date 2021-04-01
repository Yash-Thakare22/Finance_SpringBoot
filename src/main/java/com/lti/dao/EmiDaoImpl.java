package com.lti.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import org.springframework.stereotype.Repository;

import com.lti.bean.Consumer;
import com.lti.bean.Emi;
import com.lti.bean.Product;
import com.lti.exceptions.HrExceptions;

@Repository
public class EmiDaoImpl implements EmiDao {

	@PersistenceContext
	private EntityManager manager;
	
	@Override
	public boolean addEmi(int cid,int pid,Emi em) throws HrExceptions {
//		Query qry = manager.createQuery(
//		        "Select count(*) from emi_s e where e.consumerId = :id1 and e.productId = :id2");
//		qry.setParameter("id1", cid);
//		qry.setParameter("id2", pid);
//		Long count = (Long)qry.getSingleResult();
//		if(count==0)
//		{
//			Product p=manager.find(Product.class, pid);
//			em.setProduct(p);
//			Consumer c=manager.find(Consumer.class, cid);
//			em.setConsumer(c);
//			manager.persist(em);
//			return true;
//		}
//		return false;
		Product p=manager.find(Product.class, pid);
		em.setProduct(p);
		Consumer c=manager.find(Consumer.class, cid);
		em.setConsumer(c);
		manager.persist(em);
		return true;	
	}

	@Override
	public boolean updateEmi(int cid, int pid, Emi em) throws HrExceptions {
		Product p=manager.find(Product.class, pid);
		em.setProduct(p);
		Consumer c=manager.find(Consumer.class, cid);
		em.setConsumer(c);
		manager.merge(em);
		return true;	
		
	}

	@Override
	public List<Emi> displayCardDetails(long cardNo) throws HrExceptions {
		String strQry ="Select e from Emi e where e.cardNumber =: card";
		Query qry = manager.createQuery(strQry);
		qry.setParameter("card", cardNo);
		List<Emi> list=qry.getResultList();
		return (List<Emi>) list ;
	}
	
	
	
	
	
	

}
