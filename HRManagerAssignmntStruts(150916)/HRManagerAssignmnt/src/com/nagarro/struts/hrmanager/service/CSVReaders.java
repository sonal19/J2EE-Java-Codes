package com.nagarro.struts.hrmanager.service;

import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import com.nagarro.struts.hrmanager.model.EmployeeDetail;
import com.nagarro.struts.hrmanager.utils.ConverterClass;
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
	 * @param s
	 *            the csv file path
	 * @return the array list after storing the results from the given csv files
	 */
	@SuppressWarnings({ "rawtypes", "unchecked" })
	public static List readCSVFile(final File file) {

		final List readList = new ArrayList();

		try (CSVReader reader = new CSVReader(new FileReader(file), '|', '"', 1);) {

			String[] line;
			while ((line = reader.readNext()) != null) {
				if (line.length > 1) {
					final EmployeeDetail empObj=new EmployeeDetail();
					empObj.setEmpNumber(Integer.parseInt(line[0]));
					empObj.setEmpName(line[1]);
					empObj.setEmpLocation(line[2]);
					empObj.setEmpEmail(line[3]);
					empObj.setEmpDOB(ConverterClass.convertStringToDate(line[4], "dd-MM-yyyy"));
					readList.add(empObj);
				}
			}
		} catch (final IOException e) {
			//UserInput.LOGGER.trace(e.getMessage());
		}

		return readList;
	}

}
