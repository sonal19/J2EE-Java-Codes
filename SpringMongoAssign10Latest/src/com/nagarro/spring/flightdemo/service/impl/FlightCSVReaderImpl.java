package com.nagarro.spring.flightdemo.service.impl;

import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import com.nagarro.spring.flightdemo.bean.FlightDetail;
import com.nagarro.spring.flightdemo.service.FlightCSVReader;
import com.opencsv.CSVReader;


/**
 * The Class flightCSVReaders reads the csv file from the directory and parse the
 * value from it using the delimiter.
 * 
 * @author ricktamkundu
 */
public class FlightCSVReaderImpl implements FlightCSVReader {
	/**
	 * the instance of the singleton class which is used to save the overhead of
	 * defining new object.
	 */
	private static FlightCSVReaderImpl instance = null;

	/**
	 * Instantiates a new flight CSV Reader impl constructor so that new object
	 * cant be created.
	 */
	private FlightCSVReaderImpl() {

	}

	/**
	 * Gets the single instance of FlightCSVReaderImpl.It checks for the
	 * previous flight if it is not available then create a new instance
	 *
	 * @return single instance of FlightCSVReaderImpl
	 */
	public static FlightCSVReaderImpl getInstance() {
		if (instance == null) {
			instance = new FlightCSVReaderImpl();
		}
		return instance;
	}
	/* (non-Javadoc)
	 * @see com.nagarro.struts.hrmanager.service.flightCSVReader#readCSVFile(java.io.File)
	 */
	@SuppressWarnings({ "unchecked", "rawtypes" })
	@Override
	public List readCSVFile(File file, String airwaysName, int flightCount) {
		final List readList = new ArrayList();

		try (CSVReader reader = new CSVReader(new FileReader(file), '|', '"', 1);) {

			String[] line;
			while ((line = reader.readNext()) != null) {
				if (line.length > 1) {
					final FlightDetail flightObj = new FlightDetail();
					flightObj.setFlightId(flightCount);
					flightObj.setFlightNum(line[0]);
					flightObj.setDepLoc(line[1]);
					flightObj.setArrLoc(line[2]);
					flightObj.setValidTill(line[3]);
					/*flightObj.setEmpDOB(ConverterClass.convertStringToDate(line[4], "dd-MM-yyyy"));*/
					flightObj.setFlightTime(line[4]);
					flightObj.setFlightDuration(Double.parseDouble(line[5]));
					flightObj.setFare(Double.parseDouble(line[6]));
					flightObj.setSeatAvailibility(line[7]);
					flightObj.setFlightClass(line[8]);
					flightObj.setAirwaysName(airwaysName);
					readList.add(flightObj);
					flightCount++;
				}
			}
		} catch (final IOException e) {
			//MyLoggingInterceptor.LOGGER.debug(e);
		}

		return readList;
	}

	
}
