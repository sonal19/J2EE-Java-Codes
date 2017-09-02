package com.nagarro.flightdemo.presentation;

import com.nagarro.flightdemo.exception.UserExceptionClass;
import com.nagarro.flightdemo.services.ExceptionManager;

/**
 * The Class DisplayResults.
 */
public class DisplayResults {

	/**
	 * The main method.
	 *
	 * @param args the arguments
	 * @throws UserExceptionClass the user exception class
	 */
	public static void main(final String[] args) throws UserExceptionClass {
		// TODO Auto-generated method stub
		
		UserInput.logInitialization();
		ExceptionManager.handleException();
		
		
	}
	

}
