package com.nagarro.struts.hrmanager.service.impl;

import java.io.File;
import java.io.FileInputStream;
import java.io.InputStream;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.Properties;

import javax.servlet.http.HttpServletResponse;

import com.nagarro.struts.hrmanager.dao.EmployeeDao;
import com.nagarro.struts.hrmanager.dao.impl.EmployeeDaoImpl;
import com.nagarro.struts.hrmanager.dto.FileUploadDetail;
import com.nagarro.struts.hrmanager.exception.UserExceptionClass;
import com.nagarro.struts.hrmanager.model.EmployeeDetail;
import com.nagarro.struts.hrmanager.service.CSVReaders;
import com.nagarro.struts.hrmanager.service.EmployeeService;
import com.nagarro.struts.hrmanager.utils.ConverterClass;
import com.nagarro.struts.hrmanager.utils.ReadCSVFromStream;
import com.nagarro.struts.hrmanager.utils.ReadFromProperties;
import com.opensymphony.xwork2.ActionSupport;

public class EmployeeServiceImpl implements EmployeeService {

	
	EmployeeDao empDao = new EmployeeDaoImpl();

	@SuppressWarnings({ "rawtypes", "unchecked" })
	@Override
	public void addEmployee(List empList) {

		try {
			empDao.insertDetails(empList);
		} catch (UserExceptionClass e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

	@SuppressWarnings("rawtypes")
	@Override
	public List getEmployee() {
		List retVal = new ArrayList<>();
		try {
			retVal = empDao.getDetails();
		} catch (UserExceptionClass e) {
			System.out.println("--->");
			e.printStackTrace();
		}
		return retVal;
	}

	@SuppressWarnings({ "unchecked", "rawtypes" })
	@Override
	public String readFile(FileUploadDetail fileDetails) {
		try {

			final InputStream filecontent = new FileInputStream(fileDetails.getUsersFile());
			final byte[] fileBytes = new byte[(int) fileDetails.getUsersFile().length()];
			filecontent.read(fileBytes);
			filecontent.close();
			File tempCSV = ReadCSVFromStream.csvStreamReader(fileBytes);

			List empList = new ArrayList<>();
			empList.addAll(CSVReaders.readCSVFile(tempCSV));
			addEmployee(empList);

		} catch (Exception e) {
			e.printStackTrace();
			// addActionError(e.getMessage());

			return ActionSupport.ERROR;
		}
		return ActionSupport.SUCCESS;
	}

	@SuppressWarnings("unchecked")
	@Override
	public String writeCSVFile(HttpServletResponse response) {
		response.setContentType("text/csv");

		try {
			//Properties props = ReadFromProperties.readProperties("SQLQuery.properties");
			
			List<EmployeeDetail> empList = new ArrayList<EmployeeDetail>();
			empList.addAll(getEmployee());

			response.setHeader("Content-disposition", "attachment; filename=\"employee.csv\"");
			PrintWriter out = response.getWriter();
			System.out.println("download");
			out.println("EmpCode|EmpName|Location|Email|DOB");
			for (EmployeeDetail empObj : empList) {
				out.println(empObj.getEmpNumber() + "|" + empObj.getEmpName() + "|" + empObj.getEmpLocation() + "|"
						+ empObj.getEmpEmail() + "|"
						+ ConverterClass.convertDateToString(empObj.getEmpDOB(), "DD-MM-YYYY"));
			}

			out.flush();
			out.close();

		} catch (Exception e) {
			System.out.println(e.toString());
		}
		return null;
	}

	@Override
	public String editEmployee(EmployeeDetail empDetail) {
		String retVal = null;
		try {
			if (empDao.isDetailsUpdated(empDetail)) {
				retVal = ActionSupport.SUCCESS;
			} else {
				retVal = ActionSupport.ERROR;
			}
		} catch (UserExceptionClass e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return retVal;
	}

	@Override
	public String deleteEmployee(int empNumber) {
		String retVal = null;
		try {
			if (empDao.isDetailsDeleted(empNumber)) {
				retVal = ActionSupport.SUCCESS;
			} else {
				retVal = ActionSupport.ERROR;
			}
		} catch (UserExceptionClass e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return retVal;
	}

	@Override
	public List searchEmployee(String searchString) {
		List retVal = new ArrayList<>();
		try {
			retVal = empDao.searchDetails(searchString);
		} catch (UserExceptionClass e) {
			System.out.println("--->");
			e.printStackTrace();
		}
		return retVal;
	}

	@Override
	public List orderEmployeeById() {
		List retVal = new ArrayList<>();
		try {
			retVal = empDao.OrderById();
		} catch (UserExceptionClass e) {
			System.out.println("--->");
			e.printStackTrace();
		}
		return retVal;
	}

}
