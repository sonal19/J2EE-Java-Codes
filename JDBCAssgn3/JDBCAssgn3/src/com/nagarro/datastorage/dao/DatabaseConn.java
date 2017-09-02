package com.nagarro.datastorage.dao;

import java.sql.*;

import com.nagarro.datastorage.constants.Constants;
import com.nagarro.datastorage.presentation.UserInput;

// TODO: Auto-generated Javadoc
/**
 * The Class DatabaseConn.
 */
public class DatabaseConn {

	/**
	 * Access database.
	 *
	 * @param query
	 *            the query
	 * @return true, if successful
	 */
	public static boolean accessDatabase(final String query) {
		// TODO Auto-generated method stub
		boolean retVal = false;
		try {
			Class.forName("com.mysql.jdbc.Driver");
			final Connection con = DriverManager.getConnection(Constants.SQL_CONNECTION, UserInput.userName,
					UserInput.password);
			final Statement st = con.createStatement();
			ResultSet rs = null;
			@SuppressWarnings("unused")
			int update = 0;

			if ((query.split(" "))[0].equalsIgnoreCase("CREATE") || (query.split(" "))[0].equalsIgnoreCase("INSERT")) {
				update = st.executeUpdate(query);
			} else {
				rs = st.executeQuery(query);
			}
			if (rs != null) {
				while (rs.next()) {
					System.out.print(rs.getInt("id") + "\t" + rs.getString("name"));
					System.out.println();
					retVal = true;
				}
			}

		} catch (final ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (final SQLException e) {
			// TODO Auto-generated catch block
			// e.printStackTrace();
		}
		return retVal;

	}

}
