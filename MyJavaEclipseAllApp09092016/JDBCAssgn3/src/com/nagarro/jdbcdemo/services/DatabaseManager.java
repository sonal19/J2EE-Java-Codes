package com.nagarro.jdbcdemo.services;

import com.nagarro.jdbcdemo.constants.Constants;
import com.nagarro.jdbcdemo.dao.DBConnector;

/**
 * The Class DatabaseManager manage the databases which can of any type.Mainly
 * concentrated on SQL,MYSQL,ORACLE and POSTGRES.
 */
public class DatabaseManager {

	/**
	 * Manage database by giving their driver and the connection url for
	 * different Databases.
	 *
	 * @param databaseType
	 *            the database type is the choice for the database given in the
	 *            console window
	 */
	public static void manageDatabase(final int databaseType) {

		switch (databaseType) {
		case 1:
			DBConnector.connectionURL = Constants.MYSQL_CONNECTION;
			DBConnector.driverName = Constants.MYSQL_DRIVER_NAME;
			break;
		case 2:
			DBConnector.connectionURL = Constants.SQL_CONNECTION;
			DBConnector.driverName = Constants.SQL_DRIVER_NAME;
			break;
		case 3:
			DBConnector.connectionURL = Constants.ORACLE_CONNECTION;
			DBConnector.driverName = Constants.ORACLE_DRIVER_NAME;
			break;
		case 4:
			DBConnector.connectionURL = Constants.DB2_CONNECTION;
			DBConnector.driverName = Constants.DB2_DRIVER_NAME;
			break;
		case 5:
			DBConnector.connectionURL = Constants.POSTGRES_CONNECTION;
			DBConnector.driverName = Constants.POSTGRES_DRIVER_NAME;
			break;
		default:
			break;

		}

	}

}
