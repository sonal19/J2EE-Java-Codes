package com.nagarro.jdbcdemo.utils;

import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

import com.nagarro.jdbcdemo.domain.FlightDetail;
import com.nagarro.jdbcdemo.presentation.UserInput;
import com.opencsv.CSVReader;

/**
 * The Class CSVReaders reads the csv file from the directory and parse the
 * value from it using the delimiter.
 * 
 * @author ricktamkundu
 */
public class CSVReaders {

	/**
	 * Read CSV file from the given directory and the path and parse it on the
	 * basis of the given delimiter in the csv file.
	 *
	 * @param csvFile
	 *            the csv file path
	 * @return the array list after storing the results from the given csv files
	 */
	public static ArrayList<FlightDetail> readCSVFile(final String csvFile) {

		final ArrayList<FlightDetail> flightDetailsList = new ArrayList<FlightDetail>();

		CSVReader reader = null;
		try {
			reader = new CSVReader(new FileReader(csvFile), '|', '"', 1);

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
			UserInput.LOGGER.trace(e.getMessage());
		}

		return flightDetailsList;
	}

}
