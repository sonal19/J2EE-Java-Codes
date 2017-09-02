package com.nagarro.struts.hrmanager.dao;

import java.sql.PreparedStatement;
import java.util.ArrayList;
import java.util.List;

import com.nagarro.struts.hrmanager.exception.ErrorCodes;
import com.nagarro.struts.hrmanager.exception.UserExceptionClass;
import com.nagarro.struts.hrmanager.model.EmployeeDetail;
import com.nagarro.struts.hrmanager.utils.CSVReaders;
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

	@Override
	public void getDetails() {

	}

}
