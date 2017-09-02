package com.nagarro.datastorage.services;

import java.security.NoSuchAlgorithmException;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import com.nagarro.datastorage.dao.DAOFactory;
import com.nagarro.datastorage.domain.FlightDetail;
import com.nagarro.datastorage.utils.MD5Hashing;

// TODO: Auto-generated Javadoc
/**
 * The Class InsertData.
 */
public class InsertData {

	/**
	 * Insert flight data.
	 *
	 * @param ps the ps
	 * @param flightObject the flight object
	 * @throws SQLException the SQL exception
	 * @throws NoSuchAlgorithmException the no such algorithm exception
	 */

	public static void insertFlightData(PreparedStatement ps, FlightDetail flightObject)
			throws SQLException, NoSuchAlgorithmException {
		// String query=null;
		String rowData = flightObject.getFlightNum() + flightObject.getDepLoc() + flightObject.getArrLoc()
				+ flightObject.getValidTill() + flightObject.getFlightTime() + flightObject.getFlightDuration()
				+ flightObject.getFare() + flightObject.getSeatAvailibility() + flightObject.getFlightClass();
		
		DAOFactory.mapParams(ps, flightObject.getFlightNum(), flightObject.getDepLoc(), flightObject.getArrLoc(),
				flightObject.getValidTill(), flightObject.getFlightTime(), flightObject.getFlightDuration(),
				flightObject.getFare(), flightObject.getSeatAvailibility(), flightObject.getFlightClass(),
				MD5Hashing.md5Hashing(rowData).toString());

		// DatabaseConn.updateQueries(Constants.INSERT_QUERY);

	}
}
