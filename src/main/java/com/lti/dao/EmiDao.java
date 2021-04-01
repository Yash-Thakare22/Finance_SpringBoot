package com.lti.dao;



import java.util.List;

import com.lti.bean.Emi;
import com.lti.exceptions.HrExceptions;

public interface EmiDao {
	
	public boolean addEmi(int cid,int pid,Emi em) throws HrExceptions;
	//public void deleteEmi(int id ) throws HrExceptions;
	public boolean updateEmi(int cid,int pid,Emi em) throws HrExceptions;
    public List<Emi> displayCardDetails(long cardNo) throws HrExceptions;
	

}
