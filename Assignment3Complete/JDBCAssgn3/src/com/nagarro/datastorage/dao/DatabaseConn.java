package com.nagarro.datastorage.dao;

import java.sql.DatabaseMetaData;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.nagarro.datastorage.constants.Constants;
import com.nagarro.datastorage.domain.FlightDetail;
import com.nagarro.datastorage.exception.ErrorCodes;
import com.nagarro.datastorage.exception.UserExceptionClass;
import com.nagarro.datastorage.presentation.UserInput;
import com.nagarro.datastorage.services.FilterCSVFile;
import com.nagarro.datastorage.services.InsertData;

// TODO: Auto-generated Javadoc
/**
 * The Class DatabaseConn which connect to the database and run different
 * queries basically CRUD operation.
 */
public class DatabaseConn {

	/**
	 * Update queries.
	 *
	 * @param query
	 *            the query
	 * @throws SQLException
	 *             the SQL exception
	 * @throws UserExceptionClass
	 *             the user exception class
	 */
	@SuppressWarnings({ "unchecked", "rawtypes" })
	public static void updateQueries(final String query) throws SQLException, UserExceptionClass {

		try (final PreparedStatement ps = DAOFactory.getConnection().prepareStatement(query);) {

			if (!(query.split(" "))[0].equalsIgnoreCase("CREATE")) {

				final List<FlightDetail> flightList = new ArrayList();
				flightList.addAll(FilterCSVFile.filterCSVFile("."));
				int update = 0;
				for (FlightDetail flightObject : flightList) {
					InsertData.insertFlightData(ps, flightObject);
					update += ps.executeUpdate();

				}
				UserInput.LOGGER.debug(update + "Rows Updated");
			} else {
				final int update = ps.executeUpdate();
				UserInput.LOGGER.debug(update + "Table Created");
			}

		} catch (Exception e) {
			throw new UserExceptionClass(ErrorCodes.DUPLICATE);

			// UserInput.LOGGER.error(e);
		}
	}

	/**
	 * Select queries.
	 *
	 * @param query
	 *            the query
	 * @throws SQLException
	 *             the SQL exception
	 * @throws UserExceptionClass
	 *             the user exception class
	 */
	@SuppressWarnings("unused")
	public static void selectQueries(final String query) throws SQLException, UserExceptionClass {
		try {
			final Statement st = DAOFactory.getConnection().createStatement();
			final ResultSet rs = st.executeQuery(query);

		} catch (Exception e) {
			throw new UserExceptionClass(ErrorCodes.CONNECTIONFAIL);

			// UserInput.LOGGER.error(e);
		}

	}

	/**
	 * * checks if a given table already exists.
	 *
	 * @return true, if successful
	 * @throws UserExceptionClass
	 *             the user exception class
	 */
	@SuppressWarnings("unused")
	public static boolean ifTableExists() throws UserExceptionClass {
		boolean retVal = false;
		try {
			DatabaseMetaData metadata = DAOFactory.getConnection().getMetaData();
			ResultSet results = metadata.getTables(null, null, "%", new String[] { "TABLE" });
			int i = 1;
			while (results.next()) {

				if (results.getString("TABLE_NAME").equalsIgnoreCase(Constants.TABLE_NAME))
					retVal = true;
				i++;
			}
		} catch (Exception e) {
			retVal = false;
			throw new UserExceptionClass(ErrorCodes.NOTABLE);

		}
		return retVal;
	}

	/**
	 * If database exists.
	 *
	 * @return true, if successful
	 */
	public static boolean ifDatabaseExists() {
		boolean retVal = true;
		try (final Statement st = DAOFactory.getConnection().createStatement();) {

			int update = st.executeUpdate(Constants.CREATE_DB);
			if (update > 0) {
				retVal = false;
			}
		} catch (Exception e) {
			retVal = true;
			// UserInput.LOGGER.error(e);
		}
		// DAOFactory.connectionURL=Constants.SQL_CONNECTION+Constants.DB_NAME;
		return retVal;
	}
}
