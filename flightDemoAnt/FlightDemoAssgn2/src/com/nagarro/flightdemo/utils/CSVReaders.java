package com.nagarro.flightdemo.utils;

import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

import com.nagarro.flightdemo.dto.FlightDetails;
import com.nagarro.flightdemo.presentation.UserInput;
import com.opencsv.CSVReader;

/**
 * The Class CSVReaders.
 * 
 * @author ricktamkundu
 */
public class CSVReaders {

	/**
	 * Read CSV file.
	 *
	 * @param csvFile
	 *            the csv file path
	 * @return the array list after storing the results from the given csv files
	 */
	public static ArrayList<FlightDetails> readCSVFile(final String csvFile) {

		final ArrayList<FlightDetails> flightDetailsList = new ArrayList<FlightDetails>();

		CSVReader reader = null;
		try {
			reader = new CSVReader(new FileReader(csvFile), '|', '"', 1);

			String[] line;
			while ((line = reader.readNext()) != null) {
				if (line.length > 1) {
					final FlightDetails flightDetailsObj = new FlightDetails();
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
		} catch (final IOException e) {
			UserInput.LOGGER.debug(e);
		} finally {
			try {
				reader.close();
			} catch (final IOException e) {
				// TODO Auto-generated catch block
				UserInput.LOGGER.debug(e);
			}
		}
		return flightDetailsList;
	}

}
