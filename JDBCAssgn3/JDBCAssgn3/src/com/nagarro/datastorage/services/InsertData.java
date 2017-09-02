package com.nagarro.datastorage.services;

import java.util.ArrayList;
import java.util.List;

import com.nagarro.datastorage.dao.DatabaseConn;
import com.nagarro.datastorage.domain.FlightDetail;

// TODO: Auto-generated Javadoc
/**
 * The Class InsertData.
 */
public class InsertData {

	/**
	 * Insert flight data.
	 */
	@SuppressWarnings("unchecked")
	public static void insertFlightData(){
		String query=null;
		final List<FlightDetail> flightList = new ArrayList();
		flightList.addAll(FilterCSVFile.filterCSVFile("."));
		
		for(FlightDetail flightObject:flightList){
			
			query="INSERT INTO Flight_Details values('"+flightObject.getFlightNum()+"','"+flightObject.getDepLoc()+"',"
					+ "'"+flightObject.getArrLoc()+"','"+flightObject.getValidTill()+"','"+flightObject.getFlightTime()+"',"
							+ ""+flightObject.getFlightDuration()+","+flightObject.getFare()+",'"+flightObject.getSeatAvailibility()+"',"
									+ "'"+flightObject.getFlightClass()+"')";
			System.out.println(query);
			DatabaseConn.accessDatabase(query);
		}
		
		
	}
}
