package com.nagarro.struts.hrmanager.actions;

import java.io.Serializable;

import javax.servlet.http.HttpServletResponse;

import org.apache.struts2.ServletActionContext;

import com.nagarro.struts.hrmanager.service.EmployeeService;
import com.nagarro.struts.hrmanager.service.impl.EmployeeServiceImpl;
import com.opensymphony.xwork2.ActionSupport;

public class FileDownloadAction extends ActionSupport implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public String execute() {
		HttpServletResponse response = ServletActionContext.getResponse();
		EmployeeService empService = new EmployeeServiceImpl();
		empService.writeCSVFile(response);
		System.out.println("Hi there");
		return "SUCCESS";

	}
}
