package com.nagarro.struts.hrmanager.dao;

import java.util.List;

import com.nagarro.struts.hrmanager.exception.UserExceptionClass;
import com.nagarro.struts.hrmanager.model.EmployeeDetail;

public interface EmployeeDao {
	
	void insertDetails(List<EmployeeDetail> empList) throws UserExceptionClass;
	
	void getDetails();

}
