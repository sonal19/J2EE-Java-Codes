package com.nagarro.struts.hrmanager.actions;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import java.util.Properties;

import com.nagarro.struts.hrmanager.service.EmployeeService;
import com.nagarro.struts.hrmanager.service.impl.EmployeeServiceImpl;
import com.nagarro.struts.hrmanager.utils.ReadFromProperties;
import com.opensymphony.xwork2.ActionSupport;

public class EmployeeListAction extends ActionSupport implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private String searchString;
	
	public String getSearchString() {
		return searchString;
	}

	public void setSearchString(String searchString) {
		this.searchString = searchString;
	}

	@SuppressWarnings("rawtypes")
	private List employeeList=new ArrayList<>();
	
	@SuppressWarnings("rawtypes")
	public List getEmployeeList() {
		return employeeList;
	}

	@SuppressWarnings("rawtypes")
	public void setEmployeeList(List employeeList) {
		this.employeeList = employeeList;
	}

	@SuppressWarnings("unchecked")
	public String execute() {
		
		String returnVal=null;
		EmployeeService empService = new EmployeeServiceImpl();
		//Properties props = ReadFromProperties.readProperties("SQLQuery.properties");
		employeeList.addAll(empService.getEmployee());
		if(employeeList.size()>0){
			returnVal=ActionSupport.SUCCESS;
		}
		else{
			returnVal=ActionSupport.INPUT;
		}
		return returnVal;
	}
	
	@SuppressWarnings("unchecked")
	public String searchData(){
		String returnVal=null;
		EmployeeService empService = new EmployeeServiceImpl();
		//Properties props = ReadFromProperties.readProperties("SQLQuery.properties");
		employeeList.addAll(empService.searchEmployee(searchString));
		if(employeeList.size()>0){
			returnVal=ActionSupport.SUCCESS;
		}
		else{
			returnVal=ActionSupport.INPUT;
		}
		return returnVal;
	}
	
	public String orderByEmpId(){
		String returnVal=null;
		EmployeeService empService = new EmployeeServiceImpl();
		//Properties props = ReadFromProperties.readProperties("SQLQuery.properties");
		employeeList.addAll(empService.orderEmployeeById());
		if(employeeList.size()>0){
			returnVal=ActionSupport.SUCCESS;
		}
		else{
			returnVal=ActionSupport.INPUT;
		}
		return returnVal;
	}

}
