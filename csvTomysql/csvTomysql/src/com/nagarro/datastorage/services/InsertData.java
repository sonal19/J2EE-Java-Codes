package com.nagarro.datastorage.services;

import java.util.ArrayList;

import com.nagarro.datastorage.dao.DatabaseConn;
import com.nagarro.datastorage.dto.FlightDetails;

public class InsertData {

	public static void insertFlightData(){
		String query=null;
		final ArrayList<FlightDetails> flightList = new ArrayList<FlightDetails>();
		flightList.addAll(FilterCSVFile.filterCSVFile("."));
		
		for(FlightDetails flightObject:flightList){
			
			query="INSERT INTO Flight_Details values('"+flightObject.getFlightNum()+"','"+flightObject.getDepLoc()+"',"
					+ "'"+flightObject.getArrLoc()+"','"+flightObject.getValidTill()+"','"+flightObject.getFlightTime()+"',"
							+ ""+flightObject.getFlightDuration()+","+flightObject.getFare()+",'"+flightObject.getSeatAvailibility()+"',"
									+ "'"+flightObject.getFlightClass()+"')";
			System.out.println(query);
			DatabaseConn.accessDatabase(query);
		}
		
		
	}
}
