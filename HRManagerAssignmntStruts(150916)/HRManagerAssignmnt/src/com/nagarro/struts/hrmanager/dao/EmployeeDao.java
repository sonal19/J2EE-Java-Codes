package com.nagarro.struts.hrmanager.dao;

import java.util.List;

import com.nagarro.struts.hrmanager.exception.UserExceptionClass;
import com.nagarro.struts.hrmanager.model.EmployeeDetail;

public interface EmployeeDao {
	
	void insertDetails(List<EmployeeDetail> empList) throws UserExceptionClass;
	
	@SuppressWarnings("rawtypes")
	List getDetails() throws UserExceptionClass;
	
	boolean isDetailsUpdated(EmployeeDetail empDetail) throws UserExceptionClass;

	boolean isDetailsDeleted(int empNumber) throws UserExceptionClass;

	List searchDetails(String searchString) throws UserExceptionClass;

	List OrderById() throws UserExceptionClass;

}
