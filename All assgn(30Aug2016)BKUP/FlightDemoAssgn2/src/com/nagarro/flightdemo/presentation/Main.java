package com.nagarro.flightdemo.presentation;

import com.nagarro.flightdemo.services.CompareFlights;
import com.nagarro.flightdemo.services.ThreadManager;
import com.nagarro.flightdemo.validation.UserInputValidation;


public class Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		
		try {
			//FilterCSVFile.readCSVFile(".");//(.) used for same directory 
		CompareFlights cf=new CompareFlights();
		cf.setSearchFlights(UserInputValidation.inputValidator());
			cf.comparer();
			  ThreadManager.threadManager();
			
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	

}
