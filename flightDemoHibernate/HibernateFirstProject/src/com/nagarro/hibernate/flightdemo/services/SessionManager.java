package com.nagarro.hibernate.flightdemo.services;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Set;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

import com.nagarro.hibernate.flightdemo.domain.FlightDetails;
import com.nagarro.hibernate.flightdemo.domain.FlightNames;

/**
 * The Class SessionManager.
 */
public class SessionManager {

	/** The session factory. */
	public static SessionFactory sessionFactory;

	/**
	 * Creates the schema.
	 *
	 * @param sessionFactory
	 *            the session factory
	 */
	public static void createSchema(SessionFactory sessionFactory) {
		SessionManager.sessionFactory = sessionFactory;
		insertValues(".");


	}

	/**
	 * Insert to database.
	 *
	 * @param path the path
	 */
	public static void insertValues(String path) {
		HashMap<String, ArrayList<FlightDetails>> fileMapper = new HashMap<String, ArrayList<FlightDetails>>();

		fileMapper = FilterCSVFile.filterCSVFile(path);
		Session session = null;
		Transaction transaction = null;

		try {
			session = sessionFactory.openSession();
			transaction = session.beginTransaction();
			Set<String> s = fileMapper.keySet();
			String[] array = s.toArray(new String[s.size()]);

			for (int i = 0; i < fileMapper.size(); i++) {

				final ArrayList<FlightDetails> flightList = new ArrayList<FlightDetails>();
				FlightNames fn = new FlightNames();

				flightList.addAll(fileMapper.get(array[i]));
				fn.setAirways(array[i]);
	
				for (FlightDetails flightObject : flightList) {
					FlightDetails flightDetails = new FlightDetails();

					// i++;
					flightDetails.setFlightNum(flightObject.getFlightNum());
					flightDetails.setDepLoc(flightObject.getDepLoc());
					flightDetails.setArrLoc(flightObject.getArrLoc());
					flightDetails.setValidTill(flightObject.getValidTill());
					flightDetails.setFare(flightObject.getFare());
					flightDetails.setFlightClass(flightObject.getFlightClass());
					flightDetails.setSeatAvailibility(flightObject.getSeatAvailibility());
					flightDetails.setFlightTime(flightObject.getFlightTime());
					flightDetails.setFlightDuration(flightObject.getFlightDuration());

					try {
						flightDetails.setAirwaysName(fn);
						session.saveOrUpdate(flightDetails);
						
						//System.out.println("------>"+session.merge(flightDetails).hashCode());
						
						
					} catch (HibernateException e) {
						transaction.rollback();

					}
				}
				session.saveOrUpdate(fn);
				

			}
			session.getTransaction().commit();
			System.out.println("Ok done");
		} catch (HibernateException e) {
			// TODO Auto-generated catch block
			transaction.rollback();
			System.out.println("Yee Handleds");
		}

	}

	/**
	 * Adds the to database.
	 *
	 * @param fileName
	 *            the file name
	 */
	public static void addToDatabase(String fileName) {
		insertValues(fileName);

	}

	/**
	 * Modify from database.
	 *
	 * @param fileName
	 *            the file name
	 */
	public static void modifyFromDatabase(String fileName) {
		deleteValues(fileName);
		insertValues(fileName);
	}

	/**
	 * Delete from database.
	 *
	 * @param fileName
	 *            the file name
	 */
	public static void deleteFromDatabase(String fileName) {

		deleteValues(fileName);

	}
	
	public static void deleteValues(String fileName){
		Session sesion = sessionFactory.openSession();
		sesion.beginTransaction();

		FlightNames flight = (FlightNames) sesion.load(FlightNames.class, fileName.replaceAll(".csv", ""));
		sesion.delete(flight);
		
		

		sesion.getTransaction().commit();
	}

}
