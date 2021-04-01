package com.lti.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import org.springframework.stereotype.Repository;

import com.lti.bean.Consumer;
import com.lti.exceptions.HrExceptions;

@Repository
public class ConsumerDaoImpl implements ConsumerDao{
	
	@PersistenceContext
	private EntityManager manager;

	@Override
	public boolean addConsumer(Consumer con) throws HrExceptions {
		manager.persist(con);
		return true;
	}

	public List<Consumer> displayConsumer() throws HrExceptions {
		String strQry ="from Consumer";
		Query qry = manager.createQuery(strQry);
		List<Consumer> list=qry.getResultList();
		return (List<Consumer>) list ;
	}

	@Override
	public boolean activateConsumer(int id) throws HrExceptions {
		Consumer p = manager.find(Consumer.class, id);
		p.setActiveUser("Yes");
		manager.persist(p);
		return true;
	}

	@Override
	public void deleteConsumer(int id) throws HrExceptions {
		Consumer temp= manager.find(Consumer.class,id);
		manager.remove(temp);
		
	}

	@Override
	public boolean updateConsumer(int id, Consumer con) throws HrExceptions {
		manager.merge(con);
		return true;	
	}

}
