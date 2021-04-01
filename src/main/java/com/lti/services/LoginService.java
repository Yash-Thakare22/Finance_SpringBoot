package com.lti.services;

import com.lti.bean.Consumer;
import com.lti.bean.Login;
import com.lti.exceptions.HrExceptions;

public interface LoginService {
	
	public boolean addLogin(Login l) throws HrExceptions;
	public boolean changePassword(Login l) throws HrExceptions;
	public int loginExists(Login l) throws HrExceptions;

}
