package com.lti.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.lti.bean.Emi;
import com.lti.dao.EmiDao;
import com.lti.exceptions.HrExceptions;

@Service
public class EmiServiceImpl implements EmiService {

	@Autowired
	private EmiDao dao;
	
	@Transactional(propagation=Propagation.REQUIRES_NEW)
	@Override
	public boolean addEmi(int cid,int pid,Emi em) throws HrExceptions {
		return dao.addEmi(cid, pid ,em);
	}

	@Transactional(propagation=Propagation.REQUIRES_NEW)
	@Override
	public boolean updateEmi(int cid, int pid, Emi em) throws HrExceptions {
		return dao.updateEmi(cid, pid, em);
	}

	@Override
	public List<Emi> displayCardDetails(long cardNo) throws HrExceptions {
		return dao.displayCardDetails(cardNo);
	}

}
