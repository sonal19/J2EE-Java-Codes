package com.nagarro.struts.hrmanager.dao;

import java.sql.DatabaseMetaData;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.nagarro.struts.hrmanager.constants.Constants;
import com.nagarro.struts.hrmanager.exception.ErrorCodes;
import com.nagarro.struts.hrmanager.exception.UserExceptionClass;

/**
 * The Class DBOperation which connect to the database and run different queries
 * basically CRUD operation.
 */
public class DBOperation {

	/**
	 * Update queries is used for any update queries like which alter the table.
	 *
	 * @param query
	 *            the query the create drop update or Insert Query
	 * @throws SQLException
	 *             the SQL exception
	 * @throws UserExceptionClass
	 *             the user exception class for handling custom exception
	 */
	@SuppressWarnings({ "unchecked", "rawtypes", "unused" })
	public static void updateQueries(final String query) throws SQLException, UserExceptionClass {

		try (final PreparedStatement ps = DBConnector.getConnection().prepareStatement(query);) {

			if (!(query.split(" "))[0].equalsIgnoreCase("CREATE")) {

				final List<FlightDetail> flightList = new ArrayList();
				flightList.addAll(FilterCSVFile.filterCSVFile("."));
				int update = 0;
				for (final FlightDetail flightObject : flightList) {
					InsertData.insertFlightData(ps, flightObject);
					update += ps.executeUpdate();

				}
				//UserInput.LOGGER.debug(update + "Rows Updated");
			} else {
				final int update = ps.executeUpdate();
				//UserInput.LOGGER.debug("Table Created");
			}

		} catch (final Exception e) {
			UserInput.LOGGER.trace(e);
			throw new UserExceptionClass(ErrorCodes.DUPLICATE);
		}
	}

	/**
	 * Select queries used to select the data from the database.
	 *
	 * @param query
	 *            the query usually select queries
	 * @throws SQLException
	 *             the SQL exception
	 * @throws UserExceptionClass
	 *             the user exception class for handling custom exception
	 */
	@SuppressWarnings("unused")
	public static void selectQueries(final String query) throws SQLException, UserExceptionClass {
		try {
			final Statement st = DBConnector.getConnection().createStatement();
			final ResultSet rs = st.executeQuery(query);

		} catch (final Exception e) {
			//UserInput.LOGGER.trace(e);
			throw new UserExceptionClass(ErrorCodes.CONNECTIONFAIL);
		}

	}

	/**
	 * * checks if a given table already exists.
	 *
	 * @return true, if successful
	 * @throws UserExceptionClass
	 *             the user exception class for handling custom exception
	 */
	@SuppressWarnings("unused")
	public static boolean ifTableExists() throws UserExceptionClass {
		boolean retVal = false;
		try {
			final DatabaseMetaData metadata = DBConnector.getConnection().getMetaData();
			final ResultSet results = metadata.getTables(null, null, "%", new String[] { "TABLE" });
			int i = 1;
			while (results.next()) {

				if (results.getString("TABLE_NAME").equalsIgnoreCase(Constants.TABLE_NAME))
					retVal = true;
				i++;
			}
		} catch (final Exception e) {
			retVal = false;
			//UserInput.LOGGER.trace(e);
			throw new UserExceptionClass(ErrorCodes.NOTABLE);

		}
		return retVal;
	}

	/**
	 * If database exists.
	 *
	 * @return true, if successful
	 * @throws UserExceptionClass
	 *             for handling custom exception
	 */
	public static boolean ifDatabaseExists() throws UserExceptionClass {
		boolean retVal = true;
		try (final Statement st = DBConnector.getConnection().createStatement();) {

			final int update = st.executeUpdate(Constants.CREATE_DB);
			if (update > 0) {
				retVal = false;
			}
		} catch (final Exception e) {
			//UserInput.LOGGER.trace(e);
			retVal = true;
			//throw new UserExceptionClass(ErrorCodes.CONNECTIONFAIL);

		}
		
		return retVal;
	}
}
