package com.nagarro.flightdemo.utils;

import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

import com.nagarro.flightdemo.dto.FlightDetails;
import com.opencsv.CSVReader;

public class CSVReaders {

	public static ArrayList<FlightDetails> readCSVFile(String csvFile) {
		// String csvFile = path;
		ArrayList<FlightDetails> flightDetailsList = new ArrayList<FlightDetails>();
		
		CSVReader reader = null;
		try {
			reader = new CSVReader(new FileReader(csvFile), '|', '"', 1);

			String[] line;
			while ((line = reader.readNext()) != null) {
				if (line.length>1) {
					FlightDetails flightDetailsObj = new FlightDetails();
					flightDetailsObj.setFlightNum(line[0]);
					flightDetailsObj.setDepLoc(line[1]);
					flightDetailsObj.setArrLoc(line[2]);
					flightDetailsObj.setValidTill(ConverterClass.convertStringToDate(line[3]));
					flightDetailsObj.setFlightTime(line[4]);
					flightDetailsObj.setFlightDuration(Double.parseDouble(line[5]));
					flightDetailsObj.setFare(Double.parseDouble(line[6]));
					flightDetailsObj.setSeatAvailibility(line[7]);
					flightDetailsObj.setFlightClass(line[8]);
				
				flightDetailsList.add(flightDetailsObj);
				}
			}
			for (FlightDetails string : flightDetailsList) {
				System.out.println(string.toString());
			}

		} catch (IOException e) {
			e.printStackTrace();
		}
		return flightDetailsList;
	}

}
