package com.nagarro.struts.hrmanager.actions;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import com.nagarro.struts.hrmanager.services.EmployeeService;
import com.nagarro.struts.hrmanager.services.EmployeeServiceImpl;
import com.opensymphony.xwork2.ActionSupport;

public class EmployeeListAction extends ActionSupport implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	/*@SuppressWarnings("rawtypes")
	private List employeeList=new ArrayList<>();
	
	@SuppressWarnings("rawtypes")
	public List getEmployeeList() {
		return employeeList;
	}

	@SuppressWarnings("rawtypes")
	public void setEmployeeList(List employeeList) {
		this.employeeList = employeeList;
	}

	@SuppressWarnings("unchecked")*/
	public String execute() {
		//EmployeeService empService = new EmployeeServiceImpl();
		//employeeList.addAll(empService.getEmployee());
		System.out.println("Hi there");
		return "SUCCESS";

	}

}
