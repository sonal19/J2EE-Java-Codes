package com.nagarro.hibernate.flightdemo.presentation;

import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.nagarro.hibernate.flightdemo.services.ExceptionManager;
import com.nagarro.hibernate.flightdemo.exception.UserExceptionClass;
import com.nagarro.hibernate.flightdemo.services.DataManager;

/**
 * The Class MainClass.
 */
public class MainClass {

	/**
	 * The main method.
	 *
	 * @param args
	 *            the arguments
	 * @throws UserExceptionClass
	 *             the user exception class
	 */
	public static void main(final String[] args) throws UserExceptionClass {
	

		final SessionFactory sessionFactory = new Configuration().configure().buildSessionFactory();

		DataManager.createSchema(sessionFactory);
		UserInput.logInitialization();
		ExceptionManager.handleException();

	}

}