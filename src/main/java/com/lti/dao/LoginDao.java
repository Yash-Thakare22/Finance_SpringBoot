package com.lti.dao;

import java.util.List;

import com.lti.bean.Consumer;
import com.lti.bean.Login;
import com.lti.exceptions.HrExceptions;

public interface LoginDao {

	public boolean addLogin(Login l) throws HrExceptions;
	public Consumer findId(String s);
	public boolean changePassword(Login l) throws HrExceptions;
    public int loginExists(Login l) throws HrExceptions;
    
}
