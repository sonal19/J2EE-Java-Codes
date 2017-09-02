package com.nagarro.jdbcdemo.constants;

/**
 * The Class Constants to store the constant values like queries, connection
 * string, Drivers etc.
 * 
 * @author ricktamkundu
 */
public class Constants {

	/*
	 * Name of fields that should be used in the string given by user for input
	 * and output
	 */

	/** The Constant FOLDER_PATH which is the current directory. */
	public static final String FOLDER_PATH = ".";

	/**
	 * The Constant RESOURCE_PATH for accessing the properties file from the
	 * resources.
	 */
	public static final String RESOURCE_PATH = "com/nagarro/jdbcdemo/resources/";

	/** The Constant DB_NAME Database Name. */
	public static final String DB_NAME = "MyDatabase";

	/** The Constant TABLE_NAME. */
	public static final String TABLE_NAME = "Flight_Details";

	/** The Constant SELECT_QUERY. */
	public static final String SELECT_QUERY = "SELECT * FROM " + TABLE_NAME;

	/** The Constant INSERT_QUERY. */
	public static final String INSERT_QUERY = "INSERT INTO Flight_Details values(?,?,?,?,?,?,?,?,?,?)";

	/** The Constant CREATE_QUERY. */
	public static final String CREATE_QUERY = "CREATE TABLE Flight_Details(FlightNumber VARCHAR(40) NOT NULL, DepartureLocation VARCHAR(10) "
			+ "NOT NULL, ArrivalLocation VARCHAR(10) NOT NULL, ValidTill VARCHAR(200), FlightTime VARCHAR(10), FlightDuration double, "
			+ "Fare double, SeatAvailability VARCHAR(2), Class VARCHAR(2),Checksum VARCHAR(50) PRIMARY KEY)";

	/** The Constant CREATE_DB. */
	public static final String CREATE_DB = "CREATE DATABASE " + DB_NAME;

	/** The Constant MYSQL_CONNECTION. */
	public static final String MYSQL_CONNECTION = "jdbc:mysql://localhost:3306/" + DB_NAME;

	/** The Constant SQL_CONNECTION. */
	public static final String SQL_CONNECTION = "jdbc:sqlserver://localhost:1433;databaseName=" + DB_NAME;

	/** The Constant ORACLE_CONNECTION. */
	public static final String ORACLE_CONNECTION = "jdbc:oracle:thin:@localhost:1521:" + DB_NAME;

	/** The Constant DB2_CONNECTION. */
	public static final String DB2_CONNECTION = "jdbc:db2://localhost:6789/" + DB_NAME;

	/** The Constant POSTGRES_CONNECTION. */
	public static final String POSTGRES_CONNECTION = "jdbc:postgresql://localhost:5432/" + DB_NAME;

	/** The Constant MYSQL_DRIVER_NAME. */
	public static final String MYSQL_DRIVER_NAME = "com.mysql.jdbc.Driver";

	/** The Constant SQL_DRIVER_NAME. */
	public static final String SQL_DRIVER_NAME = "com.microsoft.sqlserver.jdbc.SQLServerDriver";

	/** The Constant ORACLE_DRIVER_NAME. */
	public static final String ORACLE_DRIVER_NAME = "oracle.jdbc.driver.OracleDriver";

	/** The Constant DB2_DRIVER_NAME. */
	public static final String DB2_DRIVER_NAME = "com.ibm.db2.jdbc.net.DB2Driver ";

	/** The Constant POSTGRES_DRIVER_NAME. */
	public static final String POSTGRES_DRIVER_NAME = "org.postgresql.Driver";

}
