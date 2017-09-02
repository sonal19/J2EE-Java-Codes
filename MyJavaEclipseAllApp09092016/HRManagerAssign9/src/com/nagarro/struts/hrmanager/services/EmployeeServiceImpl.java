package com.nagarro.struts.hrmanager.services;

import java.util.List;

import com.nagarro.struts.hrmanager.dao.EmployeeDao;
import com.nagarro.struts.hrmanager.dao.EmployeeDaoImpl;
import com.nagarro.struts.hrmanager.exception.UserExceptionClass;

public class EmployeeServiceImpl implements EmployeeService {

	EmployeeDao empDao=new EmployeeDaoImpl();
	@SuppressWarnings("rawtypes")
	@Override
	public void addEmployee(List empList) {
		
		try {
			empDao.insertDetails(empList);
		} catch (UserExceptionClass e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
	}

}
