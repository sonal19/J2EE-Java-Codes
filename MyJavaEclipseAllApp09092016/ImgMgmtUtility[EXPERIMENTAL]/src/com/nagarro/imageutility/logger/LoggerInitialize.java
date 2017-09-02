package com.nagarro.imageutility.logger;

import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;

import com.nagarro.imageutility.constants.Constants;
import com.nagarro.imageutility.controllers.CheckUserNameServlet;

/**
 * The Class LoggerInitialize whic initialize the logger for the first time
 */
public class LoggerInitialize {
	
	/** The Constant LOGGER. */
	public static final Logger LOGGER = Logger.getLogger(CheckUserNameServlet.class.getName());
	
	/**
	 * Initialize the log properties.
	 */
	public static void logInitialization() {
		PropertyConfigurator.configure("resources/" + Constants.RESOURCE_PATH + "log4j.properties");
	}
}
