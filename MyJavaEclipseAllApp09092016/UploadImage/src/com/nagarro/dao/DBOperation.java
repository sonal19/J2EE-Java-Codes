package com.nagarro.dao;

import java.io.InputStream;
import java.sql.PreparedStatement;
import java.sql.SQLException;

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
	public static void runDB(InputStream inputStream, String firstName, String lastName, String message)  {
		 String sql = "INSERT INTO contacts (first_name, last_name, photo) values (?, ?, ?)";
		// connects to the database
		try (final PreparedStatement statement = DBConnector.getConnection().prepareStatement(sql);){

        statement.setString(1, firstName);
        statement.setString(2, lastName);
         
        if (inputStream != null) {
            // fetches input stream of the upload file for the blob column
            statement.setBlob(3, inputStream);
        }

        // sends the statement to the database server
        int row = statement.executeUpdate();
        if (row > 0) {
            message = "File uploaded and saved into database";
            System.out.println(message);
        }
        else{
        	System.out.println("Try again");
        }
    } catch (SQLException ex) {
        message = "ERROR: " + ex.getMessage();
        ex.printStackTrace();
    } 

	}

}
