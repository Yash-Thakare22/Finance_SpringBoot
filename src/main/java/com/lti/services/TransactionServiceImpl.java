package com.lti.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.lti.bean.Transaction;
import com.lti.dao.TransactionDao;
import com.lti.exceptions.HrExceptions;

@Service
public class TransactionServiceImpl implements TransactionService{

	@Autowired
	private TransactionDao dao;

	@Transactional(propagation=Propagation.REQUIRES_NEW)
	@Override
	public boolean addTransaction(int cid, int pid, Transaction t) throws HrExceptions {
		return dao.addTransaction(cid, pid, t);
	}

	@Override
	public List<Transaction> displayTransaction(long cardNo) throws HrExceptions {
		return dao.displayTransaction(cardNo);
	}
	
	
}
