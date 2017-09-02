package com.nagarro.struts.hrmanager.utils;

import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Timestamp;
import java.util.Date;

public class ParameterMapping {
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
