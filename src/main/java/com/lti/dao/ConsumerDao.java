package com.lti.dao;


import java.util.List;

import com.lti.bean.Consumer;
import com.lti.exceptions.HrExceptions;

public interface ConsumerDao {
	
	public boolean addConsumer(Consumer con) throws HrExceptions;
    public void deleteConsumer(int id) throws HrExceptions;
    public boolean updateConsumer(int id,Consumer con) throws HrExceptions;
    public List<Consumer> displayConsumer() throws HrExceptions;
//	public int CountConsumer() throws HrExceptions;  
    public boolean activateConsumer(int id) throws HrExceptions;


}
