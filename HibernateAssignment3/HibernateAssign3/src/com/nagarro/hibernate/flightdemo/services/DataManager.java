package com.nagarro.hibernate.flightdemo.services;

import java.security.NoSuchAlgorithmException;
import java.text.DecimalFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Set;

import org.hibernate.HibernateException;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

import com.nagarro.hibernate.flightdemo.domain.FlightDetails;
import com.nagarro.hibernate.flightdemo.domain.FlightNames;
import com.nagarro.hibernate.flightdemo.utils.CSVReaders;
import com.nagarro.hibernate.flightdemo.utils.MD5Hashing;

/**
 * The Class DataManager.
 */
public class DataManager {

	/** The session factory. */
	public static SessionFactory sessionFactory;

	/**
	 * Insert to database.
	 *
	 * @param path
	 *            the path
	 */
	public static void insertValues(final String path) {
		HashMap<String, ArrayList<FlightDetails>> fileMapper = new HashMap<String, ArrayList<FlightDetails>>();

		fileMapper = FilterCSVFile.filterCSVFile(path);
		Session session = null;
		Transaction transaction = null;

		try {
			session = sessionFactory.openSession();
			transaction = session.beginTransaction();
			final Set<String> s = fileMapper.keySet();
			final String[] array = s.toArray(new String[s.size()]);

			for (int i = 0; i < fileMapper.size(); i++) {

				final ArrayList<FlightDetails> flightList = new ArrayList<FlightDetails>();
				final FlightNames fnameObject = new FlightNames();

				flightList.addAll(fileMapper.get(array[i]));
				fnameObject.setAirways(array[i]);

				for (final FlightDetails flightObject : flightList) {
					final FlightDetails flightDetails = new FlightDetails();

					setFlightDetails(flightDetails, flightObject);

					try {
						flightDetails.setAirwaysName(fnameObject);
						session.saveOrUpdate(flightDetails);
						// System.out.println("------>"+session.merge(flightDetails).hashCode());

					} catch (final HibernateException e) {
						transaction.rollback();
					}
				}
				session.saveOrUpdate(fnameObject);

			}
			session.getTransaction().commit();

		} catch (final HibernateException e) {
			// TODO Auto-generated catch block
			transaction.rollback();

		}

	}

	/**
	 * Modify from database
	 *
	 * @param fileName
	 *            the file name
	 */
	@SuppressWarnings({ "unchecked" })
	public static void modifyFromDatabase(final String fileName) {
		// deleteValues(fileName);
		// insertValues(fileName);
		Session session = null;
		Transaction transaction = null;
		try {

			final DecimalFormat decimalFormat = new DecimalFormat("###.###");
			final String newFormat = "yyyy-MM-dd HH:mm:ss";
			final SimpleDateFormat dateFormat = new SimpleDateFormat(newFormat);

			session = DataManager.sessionFactory.openSession();
			transaction = session.beginTransaction();
			final Query query = session.createSQLQuery(
					"select Flight_Id,md5(concat(Arrival_Location,Departure_Location,Fare,Flight_Class,Flight_Duration,Flight_Number,Flight_Time,"
							+ "Seat_Availibility,Valid_Till)) FROM Flight_Details where airwaysName='"
							+ fileName.replaceAll(".csv", "") + "' ");

			final List<Object[]> dbFlightList = (List<Object[]>) query.list();
			@SuppressWarnings("rawtypes")
			final List md5List = new ArrayList<>();
			final List<Integer> flightIdList = new ArrayList<Integer>();
			for (final Object[] obj : dbFlightList) {
				md5List.add(obj[1]);
				flightIdList.add((Integer) obj[0]);
			}
			session.getTransaction().commit();
			final ArrayList<FlightDetails> csvFlightList = new ArrayList<FlightDetails>();
			csvFlightList.addAll(CSVReaders.readCSVFile(fileName));
			int count = 0;
			for (final FlightDetails flight : csvFlightList) {
				final String row = flight.getArrLoc() + flight.getDepLoc() + decimalFormat.format(flight.getFare())
						+ flight.getFlightClass() + decimalFormat.format(flight.getFlightDuration())
						+ flight.getFlightNum() + flight.getFlightTime() + flight.getSeatAvailibility()
						+ dateFormat.format(flight.getValidTill());

				final StringBuffer strBuf = MD5Hashing.md5Hashing(row);
				if (md5List.contains(strBuf.toString())) {
					// System.out.println("Match found");
					count++;
				} else {
					Session sessionNew = null;
					Transaction transactionNew = null;
					try {
						sessionNew = DataManager.sessionFactory.openSession();
						transactionNew = sessionNew.beginTransaction();
						/*
						 * SQLQuery q=sessionNew.
						 * createSQLQuery("UPDATE Flight_Details SET Arrival_Location='"
						 * + flight.getArrLoc() + "'," + "Departure_Location='"
						 * + flight.getDepLoc() + "',Fare=" + flight.getFare() +
						 * ",Flight_Class='" + flight.getFlightClass() + "'," +
						 * "Flight_Duration=" + flight.getFlightDuration() + ""
						 * + ",Flight_Number='" + flight.getFlightNum() +
						 * "',Flight_Time='" + flight.getFlightTime() + "'," +
						 * "Seat_Availibility='" + flight.getSeatAvailibility()
						 * + "',Valid_Till=" + flight.getValidTill() + "" +
						 * " WHERE Flight_Id=" + flightIdList.get(count) + "");
						 * q.executeUpdate();
						 */
						if (count < flightIdList.size()) {

							final FlightDetails flightObject = (FlightDetails) sessionNew.get(FlightDetails.class,
									flightIdList.get(count));
							setFlightDetails(flightObject, flight);

						} else {
							final FlightDetails flightDetails = new FlightDetails();
							setFlightDetails(flightDetails, flight);

							final FlightNames fnameObject = new FlightNames();
							fnameObject.setAirways(fileName.replaceAll(".csv", ""));
							flightDetails.setAirwaysName(fnameObject);
							sessionNew.saveOrUpdate(flightDetails);
						}
						sessionNew.getTransaction().commit();

					} catch (final Exception e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
						transactionNew.rollback();
					}
				}
			}
			if (csvFlightList.size() < flightIdList.size()) {
				Transaction transactionNew1 = null;
				try {
					final org.hibernate.classic.Session sessionNew1 = DataManager.sessionFactory.openSession();
					transactionNew1 = sessionNew1.beginTransaction();

					final FlightDetails flightObject = (FlightDetails) sessionNew1.get(FlightDetails.class,
							flightIdList.get(count));
					sessionNew1.delete(flightObject);

					sessionNew1.getTransaction().commit();

				} catch (final Exception e) {
					// TODO Auto-generated catch block
					transactionNew1.rollback();
				}
			}

		} catch (final HibernateException e) {
			// TODO Auto-generated catch block
			transaction.rollback();
		} catch (final NoSuchAlgorithmException e) {
			// TODO Auto-generated catch block
			transaction.rollback();
		}

	}

	/**
	 * Sets the flight details.
	 *
	 * @param flightObject
	 *            the flight object
	 * @param flight
	 *            the flight
	 */
	public static void setFlightDetails(final FlightDetails flightObject, final FlightDetails flight) {

		flightObject.setFlightNum(flight.getFlightNum());
		flightObject.setDepLoc(flight.getDepLoc());
		flightObject.setArrLoc(flight.getArrLoc());
		flightObject.setValidTill(flight.getValidTill());
		flightObject.setFare(flight.getFare());
		flightObject.setFlightClass(flight.getFlightClass());
		flightObject.setSeatAvailibility(flight.getSeatAvailibility());
		flightObject.setFlightTime(flight.getFlightTime());
		flightObject.setFlightDuration(flight.getFlightDuration());
	}

	/*
	 * public static void tryModify(String fileName){
	 * 
	 * ArrayList<FlightDetails> csvFlightList = new ArrayList<FlightDetails>();
	 * csvFlightList.addAll(CSVReaders.readCSVFile(fileName)); int c=0; for
	 * (FlightDetails flight : csvFlightList) { Session sessionNew = null;
	 * Transaction transactionNew = null; c=18; try { sessionNew =
	 * DataManager.sessionFactory.openSession(); transactionNew =
	 * sessionNew.beginTransaction(); SQLQuery q=sessionNew.
	 * createSQLQuery("UPDATE Flight_Details SET Arrival_Location='" +
	 * flight.getArrLoc() + "'," + "Departure_Location='" + flight.getDepLoc() +
	 * "',Fare=" + flight.getFare() + ",Flight_Class='" +
	 * flight.getFlightClass() + "'," + "Flight_Duration=" +
	 * flight.getFlightDuration() + "" + ",Flight_Number='" +
	 * flight.getFlightNum() + "',Flight_Time='" + flight.getFlightTime() + "',"
	 * + "Seat_Availibility='" + flight.getSeatAvailibility() + "',Valid_Till="
	 * + flight.getValidTill() + "" + " WHERE Flight_Id=" +
	 * flightIdList.get(count) + ""); q.executeUpdate();
	 * 
	 * FlightDetails flightObject=(FlightDetails)
	 * sessionNew.get(FlightDetails.class, c);
	 * flightObject.setFlightNum(flight.getFlightNum());
	 * flightObject.setDepLoc(flight.getDepLoc());
	 * flightObject.setArrLoc(flight.getArrLoc());
	 * flightObject.setValidTill(flight.getValidTill());
	 * flightObject.setFare(flight.getFare());
	 * flightObject.setFlightClass(flight.getFlightClass());
	 * flightObject.setSeatAvailibility(flight.getSeatAvailibility());
	 * flightObject.setFlightTime(flight.getFlightTime());
	 * flightObject.setFlightDuration(flight.getFlightDuration());
	 * sessionNew.getTransaction().commit(); c++;
	 * 
	 * } catch (Exception e) { // TODO Auto-generated catch block
	 * e.printStackTrace(); transactionNew.rollback(); }
	 * 
	 * FlightDetails flightDetails = new FlightDetails();
	 * 
	 * 
	 * flightDetails.setFlightNum(flight.getFlightNum());
	 * flightDetails.setDepLoc(flight.getDepLoc());
	 * flightDetails.setArrLoc(flight.getArrLoc());
	 * flightDetails.setValidTill(flight.getValidTill());
	 * flightDetails.setFare(flight.getFare());
	 * flightDetails.setFlightClass(flight.getFlightClass());
	 * flightDetails.setSeatAvailibility(flight. getSeatAvailibility());
	 * flightDetails.setFlightTime(flight.getFlightTime());
	 * flightDetails.setFlightDuration(flight.getFlightDuration( ));
	 * session.saveOrUpdate(flightDetails);
	 * 
	 * }
	 * 
	 * 
	 * 
	 * }
	 */

	/**
	 * Creates the schema.
	 *
	 * @param sessionFactory
	 *            the session factory
	 */
	public static void createSchema(final SessionFactory sessionFactory) {
		DataManager.sessionFactory = sessionFactory;
		insertValues(".");
	}

	/**
	 * Adds the to database.
	 *
	 * @param fileName
	 *            the file name
	 */
	public static void addToDatabase(final String fileName) {
		insertValues(fileName);

	}

	/**
	 * Delete from database.
	 *
	 * @param fileName
	 *            the file name
	 */
	public static void deleteFromDatabase(final String fileName) {

		deleteValues(fileName);

	}

	/**
	 * Delete values.
	 *
	 * @param fileName
	 *            the file name
	 */
	public static void deleteValues(final String fileName) {
		final Session sesion = sessionFactory.openSession();
		sesion.beginTransaction();
		final FlightNames flight = (FlightNames) sesion.load(FlightNames.class, fileName.replaceAll(".csv", ""));
		sesion.delete(flight);
		sesion.getTransaction().commit();
	}

}
