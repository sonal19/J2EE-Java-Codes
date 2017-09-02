package com.nagarro.struts.hrmanager.actions;

import java.io.Serializable;

import com.nagarro.struts.hrmanager.model.EmployeeDetail;
import com.nagarro.struts.hrmanager.services.EmployeeService;
import com.nagarro.struts.hrmanager.services.EmployeeServiceImpl;
import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.ModelDriven;

@SuppressWarnings("rawtypes")
public class EditEmployeeAction extends ActionSupport implements ModelDriven,Serializable {
	private static final long serialVersionUID = 1L;

	private EmployeeDetail empDetails = new EmployeeDetail();

	public EmployeeDetail getEmpDetails() {
		return empDetails;
	}

	public void setEmpDetails(EmployeeDetail empDetails) {
		this.empDetails = empDetails;
	}

	public String execute() {

		String retVal = null;
		EmployeeService empService = new EmployeeServiceImpl();
		retVal=empService.editEmployee(empDetails);
		
		return retVal;
	}

	@Override
	public Object getModel() {
		return empDetails;
	}
}
