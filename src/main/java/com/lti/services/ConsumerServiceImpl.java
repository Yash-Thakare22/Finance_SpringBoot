package com.lti.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.lti.bean.Consumer;
import com.lti.dao.ConsumerDao;
import com.lti.exceptions.HrExceptions;


@Service
public class ConsumerServiceImpl implements ConsumerService{
	
	@Autowired
	private ConsumerDao dao;

	@Transactional(propagation=Propagation.REQUIRES_NEW)
	@Override
	public boolean addConsumer(Consumer con) throws HrExceptions {
		return dao.addConsumer(con);
	}

	@Override
	public List<Consumer> displayConsumer() throws HrExceptions {
        return dao.displayConsumer();
	}

	@Transactional
	@Override
	public boolean activateConsumer(int id) throws HrExceptions {
		return dao.activateConsumer(id);
	}

	@Transactional(propagation=Propagation.REQUIRES_NEW)
	@Override
	public void deleteConsumer(int id) throws HrExceptions {
		dao.deleteConsumer(id);
		
	}

	@Transactional(propagation=Propagation.REQUIRES_NEW)
	@Override
	public boolean updateConsumer(int id, Consumer con) throws HrExceptions {
		return dao.updateConsumer(id, con);
	}

}
