package com.nagarro.struts.hrmanager.actions;

import java.io.Serializable;

import com.nagarro.struts.hrmanager.service.EmployeeService;
import com.nagarro.struts.hrmanager.service.impl.EmployeeServiceImpl;
import com.opensymphony.xwork2.ActionSupport;

public class DeleteEmployeeAction extends ActionSupport implements Serializable{
	private static final long serialVersionUID = 1L;

	private int empNumber;

	
	public int getEmpNumber() {
		return empNumber;
	}

	public void setEmpNumber(int empNumber) {
		this.empNumber = empNumber;
	}

	public String execute() {

		String retVal = null;
		EmployeeService empService = new EmployeeServiceImpl();
		retVal=empService.deleteEmployee(empNumber);
		
		return retVal;
	}

	
}
