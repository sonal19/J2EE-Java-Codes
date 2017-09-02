package com.nagarro.flightdemo.services;

import java.io.File;
import java.util.ArrayList;

import com.nagarro.flightdemo.dto.FlightDetails;
import com.nagarro.flightdemo.utils.CSVReaders;

public class FilterCSVFile {

	public static ArrayList<FlightDetails> readCSVFile(String path){
		File myDirectory = new File(path);
		String[] containingFileNames = myDirectory.list();
		for (String fileName : containingFileNames) {
			   if (fileName.endsWith(".csv")) {
				  return CSVReaders.readCSVFile(fileName.toString());
			      
			   }
			}
		return null;
	}
	
}
