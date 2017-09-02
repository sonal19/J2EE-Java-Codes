package com.nagarro.hibernate.flightdemo.utils;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * The Class ConverterClass.
 * 
 * @author ricktamkundu
 */
public class ConverterClass {

	/**
	 * Convert string to date.
	 *
	 * @param strDate
	 *            the string date
	 * @return the date
	 */
	public static Date convertStringToDate(final String strDate) {

		final SimpleDateFormat formatter = new SimpleDateFormat("dd-MM-yyyy");
		Date date = null;
		try {

			date = formatter.parse(strDate);

		} catch (final ParseException e) {
			// UserInput.LOGGER.debug(e);
		}

		return date;

	}

}
