package com.nagarro.struts.hrmanager.controllers;

import java.io.ByteArrayOutputStream;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.io.OutputStream;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.lang3.ArrayUtils;

import com.nagarro.struts.hrmanager.model.EmployeeDetail;
import com.nagarro.struts.hrmanager.services.EmployeeService;
import com.nagarro.struts.hrmanager.services.EmployeeServiceImpl;
import com.nagarro.struts.hrmanager.utils.CSVReaders;

/**
 * Servlet implementation class DownloadServlet
 */
@WebServlet("/DownloadServlet")
public class DownloadServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public DownloadServlet() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	@SuppressWarnings("unchecked")
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.setContentType("text/csv");
		// response.setHeader("Content-Disposition", "attachment;
		// filename=\"employee.csv\"");
		try {
			// OutputStream outputStream = response.getOutputStream();
			// String outputResult = "xxxx, yyyy, zzzz, aaaa, bbbb, ccccc, dddd,
			// eeee, ffff, gggg\n";

			List<EmployeeDetail> empList = new ArrayList<EmployeeDetail>();
			// empList.addAll(CSVReaders.readCSVFile(temp));
			EmployeeService empService = new EmployeeServiceImpl();
			empList.addAll(empService.getEmployee());
			/*
			 * ByteArrayOutputStream bos = new ByteArrayOutputStream();
			 * ObjectOutputStream oos = new ObjectOutputStream(bos);
			 * oos.writeObject(empList); byte[] bytes = bos.toByteArray();
			 * 
			 * String str=new String(bytes); outputStream.write(str.getBytes());
			 * // outputStream.write(oos); outputStream.flush();
			 * outputStream.close();
			 */
			// response.setHeader("Content-type","application/csv");
			response.setHeader("Content-disposition", "attachment; filename=\"employee.csv\"");
			PrintWriter out = response.getWriter();
			System.out.println("downoad");
			out.println("EmpCode|EmpName|Location|Email|DOB");
			for (EmployeeDetail nonUser : empList) {
				out.println(nonUser.getEmpNumber() + "|" + nonUser.getEmpName() + "|" + nonUser.getEmpLocation() + "|"
						+ nonUser.getEmpEmail() + "|" + nonUser.getEmpDOB());
			}

			out.flush();
			out.close();

		} catch (Exception e) {
			System.out.println(e.toString());
		}
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
