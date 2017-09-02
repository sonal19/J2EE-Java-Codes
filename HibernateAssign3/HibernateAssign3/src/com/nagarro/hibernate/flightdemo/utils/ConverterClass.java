package com.nagarro.hibernate.flightdemo.utils;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

// TODO: Auto-generated Javadoc
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
	public static Date convertStringToDate(final String strDate, final String format) {

		final SimpleDateFormat formatter = new SimpleDateFormat(format);
		Date date = null;
		try {

			date = formatter.parse(strDate);

		} catch (final ParseException e) {
			// UserInput.LOGGER.debug(e);
		}

		return date;

	}

	public static String convertDateToString(final Date date, final String format) {

		final SimpleDateFormat formatter = new SimpleDateFormat(format);
		String strDate = null;
		strDate = formatter.format(date);

		return strDate;

	}

}
