package com.lti.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.lti.bean.Consumer;
import com.lti.bean.Login;
import com.lti.dao.LoginDao;
import com.lti.exceptions.HrExceptions;

@Service
public class LoginServiceImpl implements LoginService{

	@Autowired
	private LoginDao dao;
	
	@Transactional(propagation=Propagation.REQUIRES_NEW)
	@Override
	public boolean addLogin(Login l) throws HrExceptions {
		return dao.addLogin(l);
	}

	@Override
	public int loginExists(Login l) throws HrExceptions {
		return dao.loginExists(l);
	}

	//Update Password
	@Transactional(propagation=Propagation.REQUIRES_NEW)
	@Override
	public boolean changePassword(Login l) throws HrExceptions {
		return dao.changePassword(l);
	}

}
