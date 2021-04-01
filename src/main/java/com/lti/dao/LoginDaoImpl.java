package com.lti.dao;


import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;


import org.springframework.stereotype.Repository;

import com.lti.bean.Consumer;
import com.lti.bean.Login;
import com.lti.exceptions.HrExceptions;

@Repository
public class LoginDaoImpl implements LoginDao{

	@PersistenceContext
	private EntityManager manager;
	
	@Override
	public boolean addLogin(Login l) throws HrExceptions {
		String name=l.getConsumerUsername();
		Consumer cn=findId(name);
		int id=cn.getConsumerId();
		Consumer c=manager.find(Consumer.class, id);
		l.setConsumer(c);
		manager.persist(l);
		return true;
	}

	public Consumer findId(String str)
	{
		Query qry = manager.createQuery("Select c from Consumer c where c.consumerEmail = :s");
		qry.setParameter("s", str);
		Consumer co=(Consumer) qry.getSingleResult();
		return co;
	}

	@Override
	public int loginExists(Login l) throws HrExceptions {
		int id=-9;
		String name=l.getConsumerUsername();
		String password=l.getConsumerPassword();
		Query qry = manager.createQuery("Select l from Login l where l.consumerUsername = :u and l.consumerPassword = :p");
		qry.setParameter("u", name);
		qry.setParameter("p", password);
		Login lo;
		try {
			lo = (Login) qry.getSingleResult();
		} catch (Exception e) {
			return id;
		}
		Consumer c=lo.getConsumer();
		id=c.getConsumerId();
		return id;
	}

	@Override
	public boolean changePassword(Login l) throws HrExceptions {
		String name=l.getConsumerUsername();
		Consumer cn=findId(name);
		int id=cn.getConsumerId();
		Consumer c=manager.find(Consumer.class, id);
		l.setConsumer(c);
		manager.merge(l);
		return true;	
	}
}
