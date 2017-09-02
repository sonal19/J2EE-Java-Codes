package com.nagarro.struts.hrmanager.actions;

import java.io.Serializable;

import org.apache.struts2.ServletActionContext;

import com.nagarro.struts.hrmanager.dto.FileUploadDetail;
import com.nagarro.struts.hrmanager.service.EmployeeService;
import com.nagarro.struts.hrmanager.service.impl.EmployeeServiceImpl;
import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.ModelDriven;

@SuppressWarnings("rawtypes")
public class FileUploadAction extends ActionSupport implements ModelDriven, Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private FileUploadDetail fileDetails = new FileUploadDetail();

	public FileUploadDetail getFileDetails() {
		return fileDetails;
	}

	public void setFileDetails(FileUploadDetail fileDetails) {
		this.fileDetails = fileDetails;
	}

	public String execute() {
		
		String retVal=null;
		EmployeeService empService = new EmployeeServiceImpl();

		//String filePath = ServletActionContext.getServletContext().getRealPath("/").concat("usersFile");
		retVal=empService.readFile(fileDetails);

		return retVal;
	}

	@Override
	public Object getModel() {
		return fileDetails;
	}

}
