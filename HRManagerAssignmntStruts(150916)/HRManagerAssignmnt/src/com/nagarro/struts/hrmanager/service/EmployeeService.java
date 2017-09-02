package com.nagarro.struts.hrmanager.service;

import java.util.Collection;
import java.util.List;

import javax.servlet.http.HttpServletResponse;

import com.nagarro.struts.hrmanager.dto.FileUploadDetail;
import com.nagarro.struts.hrmanager.model.EmployeeDetail;

public interface EmployeeService {
	
	@SuppressWarnings("rawtypes")
	public void addEmployee(List empList);

	@SuppressWarnings("rawtypes")
	public List getEmployee();
	
	public String readFile(FileUploadDetail fileDetails);
	
	public String writeCSVFile(HttpServletResponse response);
	
	public String editEmployee(EmployeeDetail empDetail);

	public String deleteEmployee(int empNumber);

	public List searchEmployee(String searchString);

	public List orderEmployeeById();

	 //public List<Employee> listEmployeess();
	 
	 //public Employee getEmployee(int empid);
	 
	// public void deleteEmployee(Employee employee)
}
