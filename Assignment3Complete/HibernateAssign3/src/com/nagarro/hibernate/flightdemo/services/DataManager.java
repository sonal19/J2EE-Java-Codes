package com.nagarro.hibernate.flightdemo.services;

import java.security.NoSuchAlgorithmException;
import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;

import org.hibernate.HibernateException;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

import com.nagarro.hibernate.flightdemo.constants.Constants;
import com.nagarro.hibernate.flightdemo.domain.FlightDetail;
import com.nagarro.hibernate.flightdemo.domain.FlightName;
import com.nagarro.hibernate.flightdemo.utils.CSVReaders;
import com.nagarro.hibernate.flightdemo.utils.ConverterClass;
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
	@SuppressWarnings({ "unchecked", "rawtypes" })
	public static void insertValues(final String path) {
		Map fileMapper = new HashMap();

		fileMapper = FilterCSVFile.filterCSVFile(path);
		Session session = null;
		Transaction transaction = null;

		try {
			session = sessionFactory.openSession();
			transaction = session.beginTransaction();
			final Set<String> s = fileMapper.keySet();
			final String[] array = s.toArray(new String[s.size()]);

			for (int i = 0; i < fileMapper.size(); i++) {

				final List<FlightDetail> flightList = new ArrayList();
				final FlightName fnameObject = new FlightName();

				flightList.addAll((Collection<? extends FlightDetail>) fileMapper.get(array[i]));
				fnameObject.setAirways(array[i]);

				for (final FlightDetail flightObject : flightList) {
					final FlightDetail flightDetails = new FlightDetail();

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

	/*
	 * @SuppressWarnings({ "unchecked", "unused" }) public static void
	 * addCheckSum() { Session session = null; Transaction transaction = null;
	 * try { session = DataManager.sessionFactory.openSession(); transaction =
	 * session.beginTransaction(); final Query query =
	 * session.createSQLQuery(Constants.MD5_CREATE_QUERY); FlightDetail
	 * flightObject=new FlightDetail(); final List<String> dbFlightList =
	 * (List<String>) query.list(); for (final String obj : dbFlightList) {
	 * flightObject.setChecksum(obj); } session.getTransaction().commit();
	 * 
	 * } catch (final HibernateException e) { // TODO Auto-generated catch block
	 * transaction.rollback();
	 * 
	 * }
	 * 
	 * }
	 */

	/**
	 * Modify from database.
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
			/*
			 * final String newFormat = "yyyy-MM-dd HH:mm:ss"; final
			 * SimpleDateFormat dateFormat = new SimpleDateFormat(newFormat);
			 */
			session = DataManager.sessionFactory.openSession();
			transaction = session.beginTransaction();
			final Query query = session.createSQLQuery(
					Constants.MD5_CREATE_QUERY + " where airwaysName='" + fileName.replaceAll(".csv", "") + "' ");

			final List<Object[]> dbFlightList = (List<Object[]>) query.list();
			@SuppressWarnings("rawtypes")
			final List md5List = new ArrayList<>();
			final List<Integer> flightIdList = new ArrayList<Integer>();
			for (final Object[] obj : dbFlightList) {
				md5List.add(obj[1]);
				flightIdList.add((Integer) obj[0]);
			}
			session.getTransaction().commit();
			final ArrayList<FlightDetail> csvFlightList = new ArrayList<FlightDetail>();
			csvFlightList.addAll(CSVReaders.readCSVFile(fileName));
			int count = 0;
			for (final FlightDetail flight : csvFlightList) {
				final String row = flight.getArrLoc() + flight.getDepLoc() + decimalFormat.format(flight.getFare())
						+ flight.getFlightClass() + decimalFormat.format(flight.getFlightDuration())
						+ flight.getFlightNum() + flight.getFlightTime() + flight.getSeatAvailibility()
						+ ConverterClass.convertDateToString(flight.getValidTill(), "yyyy-MM-dd HH:mm:ss");

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

							final FlightDetail flightObject = (FlightDetail) sessionNew.get(FlightDetail.class,
									flightIdList.get(count));
							setFlightDetails(flightObject, flight);

						} else {
							final FlightDetail flightDetails = new FlightDetail();
							setFlightDetails(flightDetails, flight);

							final FlightName fnameObject = new FlightName();
							fnameObject.setAirways(fileName.replaceAll(".csv", ""));
							flightDetails.setAirwaysName(fnameObject);
							sessionNew.saveOrUpdate(flightDetails);
						}
						sessionNew.getTransaction().commit();

					} catch (final Exception e) {
						
						transactionNew.rollback();
					}
				}
			}
			if (csvFlightList.size() < flightIdList.size()) {
				Transaction transactionNew1 = null;
				try {
					final org.hibernate.classic.Session sessionNew1 = DataManager.sessionFactory.openSession();
					transactionNew1 = sessionNew1.beginTransaction();

					final FlightDetail flightObject = (FlightDetail) sessionNew1.get(FlightDetail.class,
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
	public static void setFlightDetails(final FlightDetail flightObject, final FlightDetail flight) {

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
	 * ArrayList<FlightDetail> csvFlightList = new ArrayList<FlightDetail>();
	 * csvFlightList.addAll(CSVReaders.readCSVFile(fileName)); int c=0; for
	 * (FlightDetail flight : csvFlightList) { Session sessionNew = null;
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
	 * FlightDetail flightObject=(FlightDetail)
	 * sessionNew.get(FlightDetail.class, c);
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
	 * FlightDetail flightDetails = new FlightDetail();
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
		// addCheckSum();
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
		final FlightName flight = (FlightName) sesion.load(FlightName.class, fileName.replaceAll(".csv", ""));
		sesion.delete(flight);
		sesion.getTransaction().commit();
	}

}
