package com.nagarro.jdbcdemo.utils;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import com.nagarro.jdbcdemo.presentation.UserInput;

/**
 * The Class ConverterClass is the utility class for converting the date to
 * particular pattern type and date to string type .
 * 
 * @author ricktamkundu
 */
public class ConverterClass {

	/**
	 * Convert string to date with a particular pattern which is given by the
	 * format.
	 *
	 * @param strDate
	 *            the string date
	 * @param format
	 *            the format is the pattern in e=which date is needed
	 * @return the date it is in the particular pattern as needed
	 */
	public static Date convertStringToDate(final String strDate, final String format) {

		final SimpleDateFormat formatter = new SimpleDateFormat(format);
		Date date = null;
		try {

			date = formatter.parse(strDate);

		} catch (final ParseException e) {
			UserInput.LOGGER.trace(e.getMessage());
		}

		return date;

	}

}
