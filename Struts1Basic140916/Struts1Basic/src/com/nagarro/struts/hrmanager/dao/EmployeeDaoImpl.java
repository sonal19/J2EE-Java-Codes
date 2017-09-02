package com.nagarro.struts.hrmanager.dao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.nagarro.struts.hrmanager.exception.ErrorCodes;
import com.nagarro.struts.hrmanager.exception.UserExceptionClass;
import com.nagarro.struts.hrmanager.model.EmployeeDetail;
import com.nagarro.struts.hrmanager.utils.ConverterClass;
import com.nagarro.struts.hrmanager.utils.ParameterMapping;

public class EmployeeDaoImpl implements EmployeeDao {

	public EmployeeDaoImpl() {
		DBConnector.driverName = "com.mysql.jdbc.Driver";
		DBConnector.connectionURL = "jdbc:mysql://localhost:3306/HRManager";
	}

	@SuppressWarnings("unused")
	@Override
	public void insertDetails(List<EmployeeDetail> empList) throws UserExceptionClass {
		// DBConnector.driverName="com.mysql.jdbc.Driver" ;
		// DBConnector.connectionURL="jdbc:mysql://localhost:3306/HRManager";
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

	@SuppressWarnings({ "unchecked", "rawtypes" })
	@Override
	public List getDetails() throws UserExceptionClass {
		List empList = new ArrayList<EmployeeDetail>(20);
		// DBConnector.driverName="com.mysql.jdbc.Driver" ;
		// DBConnector.connectionURL="jdbc:mysql://localhost:3306/HRManager";
		String query = "SELECT * FROM EmployeeTable";
		try {
			final Statement st = DBConnector.getConnection().createStatement();
			ResultSet rs = st.executeQuery(query);
			while (rs.next()) {
				EmployeeDetail empObject = new EmployeeDetail();
				empObject.setEmpNumber(Integer.parseInt(rs.getString(1)));
				empObject.setEmpName(rs.getString(2));
				empObject.setEmpLocation(rs.getString(3));
				empObject.setEmpEmail(rs.getString(4));
				empObject.setEmpDOB(ConverterClass.convertStringToDate(rs.getString(5), "DD-MM-YYYY"));
				// empObject.setEmpDOB(rs.getString(5));
				empList.add(empObject);
			}

		} catch (final Exception e) {
			// UserInput.LOGGER.trace(e);
			throw new UserExceptionClass(ErrorCodes.DUPLICATE);
		}
		return empList;
	}

	@SuppressWarnings("unused")
	@Override
	public boolean isDetailsUpdated(EmployeeDetail empDetail) throws UserExceptionClass {
		boolean retVal = false;
		String query = "UPDATE EmployeeTable SET empName=?,empLocation=?,empEmail=?,empDOB=? where empNumber=?";
		try (final PreparedStatement ps = DBConnector.getConnection().prepareStatement(query);) {
			System.out.println(query);
			int update = 0;
			ParameterMapping.mapParams(ps, empDetail.getEmpName(), empDetail.getEmpLocation(),
					empDetail.getEmpEmail(), empDetail.getEmpDOB(),empDetail.getEmpNumber());
			update = ps.executeUpdate();
			
			retVal = true;
			// UserInput.LOGGER.debug("Table Created");

		} catch (final Exception e) {
			// UserInput.LOGGER.trace(e);
			throw new UserExceptionClass(ErrorCodes.DUPLICATE);
		}
		return retVal;
	}

	@Override
	public boolean isDetailsDeleted(int empNumber) throws UserExceptionClass {
		boolean retVal = false;
		String query = "DELETE FROM EmployeeTable where empNumber=?";
		try (final PreparedStatement ps = DBConnector.getConnection().prepareStatement(query);) {
			System.out.println(query);
			@SuppressWarnings("unused")
			int update = 0;
			ParameterMapping.mapParams(ps, empNumber);
			update = ps.executeUpdate();
			
			retVal = true;
			// UserInput.LOGGER.debug("Table Created");

		} catch (final Exception e) {
			// UserInput.LOGGER.trace(e);
			throw new UserExceptionClass(ErrorCodes.DUPLICATE);
		}
		return retVal;
	}

}
