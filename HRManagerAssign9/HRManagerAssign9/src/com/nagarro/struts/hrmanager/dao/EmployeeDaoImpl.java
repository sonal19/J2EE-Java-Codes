package com.nagarro.struts.hrmanager.dao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.nagarro.struts.hrmanager.exception.ErrorCodes;
import com.nagarro.struts.hrmanager.exception.UserExceptionClass;
import com.nagarro.struts.hrmanager.model.EmployeeDetail;
import com.nagarro.struts.hrmanager.utils.CSVReaders;
import com.nagarro.struts.hrmanager.utils.ConverterClass;
import com.nagarro.struts.hrmanager.utils.ParameterMapping;

public class EmployeeDaoImpl implements EmployeeDao {

	@Override
	public void insertDetails(List<EmployeeDetail> empList) throws UserExceptionClass {
		DBConnector.driverName="com.mysql.jdbc.Driver" ; 
		DBConnector.connectionURL="jdbc:mysql://localhost:3306/HRManager";
		String query = "INSERT INTO EmployeeTable values(?,?,?,?,?)";
		try (final PreparedStatement ps = DBConnector.getConnection().prepareStatement(query);) {

			int update = 0;
			for (final EmployeeDetail empObj : empList) {
				ParameterMapping.mapParams(ps, empObj.getEmpNumber(), empObj.getEmpName(), empObj.getEmpLocation(),
						empObj.getEmpEmail(), empObj.getEmpDOB());
				update += ps.executeUpdate();

				// UserInput.LOGGER.debug("Table Created");
			}

		} catch (final Exception e) {
			// UserInput.LOGGER.trace(e);
			throw new UserExceptionClass(ErrorCodes.DUPLICATE);
		}

	}

	@SuppressWarnings("unchecked")
	@Override
	public List getDetails() throws UserExceptionClass {
		List empList=new ArrayList<EmployeeDetail>(20);
		DBConnector.driverName="com.mysql.jdbc.Driver" ; 
		DBConnector.connectionURL="jdbc:mysql://localhost:3306/HRManager";
		String query = "SELECT * FROM EmployeeTable";
		try {final Statement st = DBConnector.getConnection().createStatement();
		ResultSet rs=st.executeQuery(query);
		while (rs.next()) {
			EmployeeDetail empObject=new EmployeeDetail();
			empObject.setEmpNumber(Integer.parseInt(rs.getString(1)));
			empObject.setEmpName(rs.getString(2));
			empObject.setEmpLocation(rs.getString(3));
			empObject.setEmpEmail(rs.getString(4));
			empObject.setEmpDOB(ConverterClass.convertStringToDate(rs.getString(5), "DD-MM-YYYY"));
            empList.add(empObject);
           }

		} catch (final Exception e) {
			// UserInput.LOGGER.trace(e);
			throw new UserExceptionClass(ErrorCodes.DUPLICATE);
		}
		return empList;
	}

}
