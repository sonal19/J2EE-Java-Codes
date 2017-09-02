package com.nagarro.hibernate.flightdemo.utils;

import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import com.nagarro.hibernate.flightdemo.constants.Constants;
import com.nagarro.hibernate.flightdemo.domain.FlightDetail;
import com.nagarro.hibernate.flightdemo.presentation.UserInput;
import com.opencsv.CSVReader;

// TODO: Auto-generated Javadoc
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
	@SuppressWarnings({ "rawtypes", "unchecked" })
	public static List readCSVFile(final String csvFile) {

		final List flightDetailsList = new ArrayList();

		try(CSVReader reader = new CSVReader(new FileReader(csvFile), Constants.DELIMETER, '"', 1);) {
			

			String[] line;
			while ((line = reader.readNext()) != null) {
				if (line.length > 1) {
					final FlightDetail flightDetailsObj = new FlightDetail();
					flightDetailsObj.setFlightNum(line[0]);
					flightDetailsObj.setDepLoc(line[1]);
					flightDetailsObj.setArrLoc(line[2]);
					flightDetailsObj.setValidTill(ConverterClass.convertStringToDate(line[3], "dd-MM-yyyy"));
					flightDetailsObj.setFlightTime(line[4]);
					flightDetailsObj.setFlightDuration(Double.parseDouble(line[5]));
					flightDetailsObj.setFare(Double.parseDouble(line[6]));
					flightDetailsObj.setSeatAvailibility(line[7]);
					flightDetailsObj.setFlightClass(line[8]);

					flightDetailsList.add(flightDetailsObj);
				}
			}
		} catch (final IOException e) {
			UserInput.LOGGER.debug(e.getMessage());
		} 
		
		return flightDetailsList;
	}

}
