package com.nagarro.datastorage.services;

import com.nagarro.datastorage.constants.Constants;
import com.nagarro.datastorage.dao.DAOFactory;

// TODO: Auto-generated Javadoc
/**
 * The Class DatabaseManager.
 */
public class DatabaseManager {

	/**
	 * Manage database.
	 *
	 * @param databaseType
	 *            the database type
	 */
	public static void manageDatabase(int databaseType) {

		switch (databaseType) {
		case 1:
			DAOFactory.connectionURL = Constants.MYSQL_CONNECTION;
			DAOFactory.driverName = Constants.MYSQL_DRIVER_NAME;
			break;
		case 2:
			DAOFactory.connectionURL = Constants.SQL_CONNECTION;
			DAOFactory.driverName = Constants.SQL_DRIVER_NAME;
			break;
		case 3:
			DAOFactory.connectionURL = Constants.ORACLE_CONNECTION;
			DAOFactory.driverName = Constants.ORACLE_DRIVER_NAME;
			break;
		case 4:
			DAOFactory.connectionURL = Constants.DB2_CONNECTION;
			DAOFactory.driverName = Constants.DB2_DRIVER_NAME;
			break;
		case 5:
			DAOFactory.connectionURL = Constants.POSTGRES_CONNECTION;
			DAOFactory.driverName = Constants.POSTGRES_DRIVER_NAME;
			break;
		default:
			break;

		}

	}

}
