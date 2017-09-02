package com.nagarro.jdbcdemo.services;

import java.security.NoSuchAlgorithmException;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Timestamp;
import java.util.Date;

import com.nagarro.jdbcdemo.domain.FlightDetail;
import com.nagarro.jdbcdemo.utils.MD5Hashing;

/**
 * The Class InsertData is used to insert the data in the database table fater
 * getting the data from the csv from the directory.
 */
public class InsertData {

	/**
	 * Insert flight data after fetching the data from the csv and inserting it
	 * into the table in the database.
	 *
	 * @param ps
	 *            the ps is the prepared statement reference for SQL Injection
	 * @param flightObject
	 *            the flight object
	 * @throws SQLException
	 *             the SQL exception
	 * @throws NoSuchAlgorithmException
	 *             the no such algorithm exception
	 */

	public static void insertFlightData(final PreparedStatement ps, final FlightDetail flightObject)
			throws SQLException, NoSuchAlgorithmException {
		// String query=null;
		final String rowData = flightObject.getFlightNum() + flightObject.getDepLoc() + flightObject.getArrLoc()
				+ flightObject.getValidTill() + flightObject.getFlightTime() + flightObject.getFlightDuration()
				+ flightObject.getFare() + flightObject.getSeatAvailibility() + flightObject.getFlightClass();

		mapParams(ps, flightObject.getFlightNum(), flightObject.getDepLoc(), flightObject.getArrLoc(),
				flightObject.getValidTill(), flightObject.getFlightTime(), flightObject.getFlightDuration(),
				flightObject.getFare(), flightObject.getSeatAvailibility(), flightObject.getFlightClass(),
				MD5Hashing.md5Hashing(rowData).toString());
	}

	/**
	 * Map params is used to map the params with the prepared statement values
	 * after getting it from the FLightObject.
	 *
	 * @param ps
	 *            the ps is the prepared statement reference for SQL Injection
	 * @param args
	 *            the args is the list of the parameters coming the csv using
	 *            domain class
	 * @throws SQLException
	 *             the SQL exception
	 */
	public static void mapParams(final PreparedStatement ps, final Object... args) throws SQLException {
		int i = 1;
		for (final Object arg : args) {
			if (arg instanceof Date) {
				ps.setTimestamp(i++, new Timestamp(((Date) arg).getTime()));
			} else if (arg instanceof Integer) {
				ps.setInt(i++, (Integer) arg);
			} else if (arg instanceof Long) {
				ps.setLong(i++, (Long) arg);
			} else if (arg instanceof Double) {
				ps.setDouble(i++, (Double) arg);
			} else if (arg instanceof Float) {
				ps.setFloat(i++, (Float) arg);
			} else {
				ps.setString(i++, (String) arg);
			}
		}
	}
}
