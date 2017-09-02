package com.nagarro.datastorage.dao;

import java.sql.*;

public class DatabaseConn {

	public static boolean accessDatabase(String query) {
		// TODO Auto-generated method stub
		boolean retVal = false;
		try {
			Class.forName("com.mysql.jdbc.Driver");
			Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/rk", "root", "tom");
			Statement st = con.createStatement();
			ResultSet rs = null;
			@SuppressWarnings("unused")
			int update=0;

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

		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			//e.printStackTrace();
		}
		return retVal;

	}

}
