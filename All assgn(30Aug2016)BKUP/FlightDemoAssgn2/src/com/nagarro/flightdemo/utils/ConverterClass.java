package com.nagarro.flightdemo.utils;


import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class ConverterClass {
	
	public static Date convertStringToDate(String strDate)  {
		
		SimpleDateFormat formatter = new SimpleDateFormat("dd-MM-yyyy");
		Date date = null;
		try {

			date = formatter.parse(strDate);
			
		} catch (ParseException e) {
			e.printStackTrace();
		}
		
		return date;
		
		
		}
		
		public static Date convertStringToTime(String StrTime)  {
		
		SimpleDateFormat formatter = new SimpleDateFormat("HH:mm");
		
		try {
			return formatter.parse(StrTime);
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
		
		}
		

		
	
}
