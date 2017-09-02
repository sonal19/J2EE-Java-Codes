package com.nagarro.struts.hrmanager.services;

import java.util.List;

import com.nagarro.struts.hrmanager.exception.UserExceptionClass;

public interface EmployeeService {
	
	@SuppressWarnings("rawtypes")
	public void addEmployee(List empList);

	public List getEmployee();

	 //public List<Employee> listEmployeess();
	 
	 //public Employee getEmployee(int empid);
	 
	// public void deleteEmployee(Employee employee)
}
