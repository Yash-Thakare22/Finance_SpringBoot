package com.lti.dao;



import java.util.List;

import com.lti.bean.Transaction;
import com.lti.exceptions.HrExceptions;

public interface TransactionDao {
	
	public boolean addTransaction(int cid,int pid,Transaction t) throws HrExceptions;
    public List<Transaction> displayTransaction(long cardNo) throws HrExceptions;

}
