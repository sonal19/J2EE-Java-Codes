package com.nagarro.struts.hrmanager.services;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileWriter;
import java.io.InputStream;
import java.io.PrintWriter;
import java.nio.CharBuffer;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletResponse;

import org.apache.commons.io.FileUtils;
import org.apache.struts2.ServletActionContext;

import com.nagarro.struts.hrmanager.dao.EmployeeDao;
import com.nagarro.struts.hrmanager.dao.EmployeeDaoImpl;
import com.nagarro.struts.hrmanager.dto.FileUploadDetail;
import com.nagarro.struts.hrmanager.exception.UserExceptionClass;
import com.nagarro.struts.hrmanager.model.EmployeeDetail;
import com.nagarro.struts.hrmanager.utils.CSVReaders;
import com.nagarro.struts.hrmanager.utils.ConverterClass;

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
	public String readFile(String filePath, FileUploadDetail fileDetails) {
		try {

			final InputStream filecontent = new FileInputStream(fileDetails.getUsersFile());
			final byte[] fileBytes = new byte[(int) fileDetails.getUsersFile().length()];
			filecontent.read(fileBytes);
			filecontent.close();

			File temp = File.createTempFile("tempfile.csv", ".tmp");

			BufferedWriter bw = new BufferedWriter(new FileWriter(temp));

			CharBuffer chbuff = CharBuffer.allocate(1024);
			for (int i = 0; i < fileBytes.length; i++) {

				chbuff.put(i, (char) fileBytes[i]);

				bw.write((char) fileBytes[i]);
				System.out.print((char) fileBytes[i]);
			}
			bw.close();

			List empList = new ArrayList<>();
			empList.addAll(CSVReaders.readCSVFile(temp));
			addEmployee(empList);

		} catch (Exception e) {
			e.printStackTrace();
			// addActionError(e.getMessage());

			return "INPUT";
		}
		return "SUCCESS";
	}

	@SuppressWarnings("unchecked")
	@Override
	public String writeCSVFile(HttpServletResponse response) {
		response.setContentType("text/csv");

		try {

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

}
