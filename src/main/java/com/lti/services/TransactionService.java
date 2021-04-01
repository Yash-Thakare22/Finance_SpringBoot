package com.lti.services;

import java.util.List;

import com.lti.bean.Transaction;
import com.lti.exceptions.HrExceptions;

public interface TransactionService {
	
	public boolean addTransaction(int cid,int pid,Transaction t) throws HrExceptions;
    public List<Transaction> displayTransaction(long cardNo) throws HrExceptions;

}
