package com.nagarro.spring.flightdemo.util;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class ConvertDateFormat {
	/**
	 * Convert Date Format with a particular pattern which is given by the
	 * format.
	 *
	 * @param strDate
	 *            the string date
	 * @param format
	 *            the format is the pattern in e=which date is needed
	 * @return the String it is in the particular pattern as needed
	 */
	public static String convertDateFormat(final String strDate, final String format) {
		String newDate = null;
		try {
			DateFormat fromFormat = new SimpleDateFormat("yyyy-MM-dd");
			fromFormat.setLenient(false);
			DateFormat toFormat = new SimpleDateFormat(format);
			toFormat.setLenient(false);
			Date date = fromFormat.parse(strDate);
			newDate = toFormat.format(date);
		} catch (ParseException e) {
			
		}
		return newDate;
		
	}
}
