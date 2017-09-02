package com.nagarro.hibernate.flightdemo.presentation;

import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.nagarro.hibernate.flightdemo.services.ExceptionManager;
import com.nagarro.hibernate.flightdemo.exception.UserExceptionClass;
import com.nagarro.hibernate.flightdemo.services.DataManager;

/**
 * The Class MainClass for calling the function and it contains the main method.
 */
public class MainClass {

	/**
	 * The main method which is creating the session Factory Object. It should
	 * be created only once in the whole life of the program.
	 *
	 * @param args
	 *            the arguments
	 * @throws UserExceptionClass
	 *             the user exception class for handling custom exceptions
	 */
	public static void main(final String[] args) throws UserExceptionClass {

		final SessionFactory sessionFactory = new Configuration().configure().buildSessionFactory();

		DataManager.createSchema(sessionFactory);
		UserInput.logInitialization();
		ExceptionManager.handleException();

	}

}