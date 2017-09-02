package com.nagarro.imageutility.services;

import java.io.File;
import java.io.FileOutputStream;
import java.io.OutputStream;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletResponse;

import org.hibernate.HibernateException;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

import com.nagarro.imageutility.models.ImageDetail;
import com.nagarro.imageutility.models.RegisterDetail;

/**
 * The Class DataManager is one the main file which is performing database
 * operation like inserting the values into data, deleting from the database add
 * updating the database.It used on the basis of directory watcher , if there is
 * any changes in the directory it will act and do the needful.
 */
public class DataManager {

	/** The session factory. */
	public static SessionFactory sessionFactory;

	/**
	 * Insert to database the values invoked from the CSV files.
	 *
	 * @param registerDetails
	 *            the path of the csv file to read its value
	 * @throws UserExceptionClass
	 *             the user exception class for handling custom exceptions
	 */
	public static void insertValues(final RegisterDetail registerDetails) {
		//sessionFactory = new Configuration().configure().buildSessionFactory();
		Session session = null;
		Transaction transaction = null;

		try {
			session = sessionFactory.openSession();
			transaction = session.beginTransaction();
			session.save(registerDetails);
			session.getTransaction().commit();

		} catch (final HibernateException e) {
			// UserInput.LOGGER.trace(e.getMessage());
			if (transaction != null) {
				transaction.rollback();
				// throw new UserExceptionClass(ErrorCodes.SESSIONERROR);
			}
		}
	}
	
	public static void insertImage(final ImageDetail imageDetails) {
		//sessionFactory = new Configuration().configure().buildSessionFactory();
		Session session = null; 
		Transaction transaction = null;

		try {
			session = sessionFactory.openSession();
			transaction = session.beginTransaction();
			session.save(imageDetails);
			session.getTransaction().commit();

		} catch (final HibernateException e) {
			// UserInput.LOGGER.trace(e.getMessage());
			if (transaction != null) {
				transaction.rollback();
				// throw new UserExceptionClass(ErrorCodes.SESSIONERROR);
			}
		}
	}
	public static boolean isAuthenticated(String uname,String pass) {
		//sessionFactory = new Configuration().configure().buildSessionFactory();
		boolean retVal=false;
		Session session = null;
		Transaction transaction = null; 

		try {
			session = sessionFactory.openSession();
			transaction = session.beginTransaction();
			Query q=session.createQuery("FROM RegisterDetail where userName=? and password=?");
			q.setString(0, uname);
			q.setString(1, pass);
			if(q.list().isEmpty()){
				System.out.println("Sorry");
			}
			else{
				retVal=true;
			}
			session.getTransaction().commit();

		} catch (final HibernateException e) {
			// UserInput.LOGGER.trace(e.getMessage());
			if (transaction != null) {
				transaction.rollback();
				// throw new UserExceptionClass(ErrorCodes.SESSIONERROR);
			}
		}
		return retVal;
	}
	
	@SuppressWarnings({ "rawtypes", "unchecked" })
	public static List getImageDetails() {
		//sessionFactory = new Configuration().configure().buildSessionFactory();
		List imageData=new ArrayList<ImageDetail>();
		
		Session session = null; 
		Transaction transaction = null;

		try {
			session = sessionFactory.openSession();
			transaction = session.beginTransaction();
			Query imageQuery=session.createQuery("FROM ImageDetail");
			imageData.addAll(imageQuery.list());
			session.getTransaction().commit();

		} catch (final HibernateException e) {
			// UserInput.LOGGER.trace(e.getMessage());
			if (transaction != null) {
				transaction.rollback();
				// throw new UserExceptionClass(ErrorCodes.SESSIONERROR);
			}
		}
		return imageData;
	}
	public static int getTableDataCount(){
		int retVal=0;
		Session session = null; 
		Transaction transaction = null;

		try {
			session = sessionFactory.openSession();
			transaction = session.beginTransaction();
			Query imageQuery=session.createQuery("FROM ImageDetail");
			retVal=imageQuery.list().size();
			session.getTransaction().commit();

		} catch (final HibernateException e) {
			// UserInput.LOGGER.trace(e.getMessage());
			if (transaction != null) {
				transaction.rollback();
				// throw new UserExceptionClass(ErrorCodes.SESSIONERROR);
			}
		}
		return retVal;
	}

	/**
	 * Modify from database if any update occurs in the directory csv.It use MD5
	 * checksum to compare the checksum value and update the particular row in
	 * the database, which bring efficiency in the code
	 *
	 * @param fileName
	 *            the file name is the name of the csv file or the name of the
	 *            airways as well
	 * @throws UserExceptionClass
	 *             the user exception class for handling custom exceptions
	 */
	/*
	 * @SuppressWarnings({ "unchecked", "unused" }) public static void
	 * modifyFromDatabase(final String fileName) throws UserExceptionClass {
	 * 
	 * Session session = null; Transaction transaction = null; try { // format
	 * the decimal numbers final DecimalFormat decimalFormat = new
	 * DecimalFormat("###.###");
	 * 
	 * session = DataManager.sessionFactory.openSession(); transaction =
	 * session.beginTransaction(); final Query query = session.createSQLQuery(
	 * Constants.MD5_CREATE_QUERY + " where airwaysName='" +
	 * fileName.replaceAll(".csv", "") + "' ");
	 * 
	 * final List<Object[]> dbFlightList = (List<Object[]>) query.list();
	 * 
	 * @SuppressWarnings("rawtypes") final List md5List = new ArrayList<>();
	 * final List<Integer> flightIdList = new ArrayList<Integer>(); for (final
	 * Object[] obj : dbFlightList) { md5List.add(obj[1]);
	 * flightIdList.add((Integer) obj[0]); } session.getTransaction().commit();
	 * final ArrayList<FlightDetail> csvFlightList = new
	 * ArrayList<FlightDetail>();
	 * csvFlightList.addAll(CSVReaders.readCSVFile(fileName)); int count = 0;
	 * for (final FlightDetail flight : csvFlightList) { final String row =
	 * flight.getArrLoc() + flight.getDepLoc() +
	 * decimalFormat.format(flight.getFare()) + flight.getFlightClass() +
	 * decimalFormat.format(flight.getFlightDuration()) + flight.getFlightNum()
	 * + flight.getFlightTime() + flight.getSeatAvailibility() +
	 * ConverterClass.convertDateToString(flight.getValidTill(),
	 * "yyyy-MM-dd HH:mm:ss");
	 * 
	 * final StringBuffer strBuf = MD5Hashing.md5Hashing(row); if
	 * (md5List.contains(strBuf.toString())) { //
	 * System.out.println("Match found"); count++; } else { Session sessionNew =
	 * null; Transaction transactionNew = null; try { sessionNew =
	 * DataManager.sessionFactory.openSession(); transactionNew =
	 * sessionNew.beginTransaction();
	 * 
	 * if (count < flightIdList.size()) {
	 * 
	 * final FlightDetail flightObject = (FlightDetail)
	 * sessionNew.get(FlightDetail.class, flightIdList.get(count));
	 * setFlightDetails(flightObject, flight);
	 * 
	 * } else { final FlightDetail flightDetails = new FlightDetail();
	 * setFlightDetails(flightDetails, flight);
	 * 
	 * final FlightName fnameObject = new FlightName();
	 * fnameObject.setAirways(fileName.replaceAll(".csv", ""));
	 * flightDetails.setAirwaysName(fnameObject);
	 * sessionNew.saveOrUpdate(flightDetails); }
	 * sessionNew.getTransaction().commit();
	 * 
	 * } catch (final Exception e) { UserInput.LOGGER.trace(e.getMessage()); if
	 * (transaction != null) { transaction.rollback(); throw new
	 * UserExceptionClass(ErrorCodes.SESSIONERROR); } } } } if
	 * (csvFlightList.size() < flightIdList.size()) { Transaction
	 * transactionNew1 = null; try { final org.hibernate.classic.Session
	 * sessionNew1 = DataManager.sessionFactory.openSession(); transactionNew1 =
	 * sessionNew1.beginTransaction();
	 * 
	 * final FlightDetail flightObject = (FlightDetail)
	 * sessionNew1.get(FlightDetail.class, flightIdList.get(count));
	 * sessionNew1.delete(flightObject);
	 * 
	 * sessionNew1.getTransaction().commit();
	 * 
	 * } catch (final Exception e) { UserInput.LOGGER.trace(e.getMessage()); if
	 * (transactionNew1 != null) { transactionNew1.rollback(); throw new
	 * UserExceptionClass(ErrorCodes.SESSIONERROR); } } }
	 * 
	 * } catch (final HibernateException e) {
	 * UserInput.LOGGER.trace(e.getMessage()); if (transaction != null) {
	 * transaction.rollback(); throw new
	 * UserExceptionClass(ErrorCodes.SESSIONERROR); } } catch (final
	 * NoSuchAlgorithmException e) { UserInput.LOGGER.trace(e.getMessage()); if
	 * (transaction != null) { transaction.rollback(); throw new
	 * UserExceptionClass(ErrorCodes.SESSIONERROR); } }
	 * 
	 * }
	 * 
	 *//**
		 * Sets the flight details by getting the input from the csv file and
		 * setting the value in the mapping class members.
		 *
		 * @param flightObject
		 *            the flight object of Flight Details type for setting the
		 *            value
		 * @param flight
		 *            the flight object of Flight Details type for getting the
		 *            value
		 * @throws NoSuchAlgorithmException
		 *             the no such algorithm exception
		 */
	/*
	 * public static void setFlightDetails(final FlightDetail flightObject,
	 * final FlightDetail flight) throws NoSuchAlgorithmException {
	 * 
	 * final DecimalFormat decimalFormat = new DecimalFormat("###.###"); final
	 * String row = flight.getArrLoc() + flight.getDepLoc() +
	 * decimalFormat.format(flight.getFare()) + flight.getFlightClass() +
	 * decimalFormat.format(flight.getFlightDuration()) + flight.getFlightNum()
	 * + flight.getFlightTime() + flight.getSeatAvailibility() +
	 * ConverterClass.convertDateToString(flight.getValidTill(),
	 * "yyyy-MM-dd HH:mm:ss");
	 * 
	 * flightObject.setFlightNum(flight.getFlightNum());
	 * flightObject.setDepLoc(flight.getDepLoc());
	 * flightObject.setArrLoc(flight.getArrLoc());
	 * flightObject.setValidTill(flight.getValidTill());
	 * flightObject.setFare(flight.getFare());
	 * flightObject.setFlightClass(flight.getFlightClass());
	 * flightObject.setSeatAvailibility(flight.getSeatAvailibility());
	 * flightObject.setFlightTime(flight.getFlightTime());
	 * flightObject.setFlightDuration(flight.getFlightDuration());
	 * flightObject.setChecksum(MD5Hashing.md5Hashing(row).toString()); }
	 * 
	 *//**
		 * Creates the schema in the database once the execution starts and
		 * insert all the initials values into it from the csv files.
		 *
		 * @param sessionFactory
		 *            the session factory passing from Main class
		 * @throws UserExceptionClass
		 *             the user exception class for handling custom exceptions
		 */
	/*
	 * public static void createSchema(final SessionFactory sessionFactory)
	 * throws UserExceptionClass { DataManager.sessionFactory = sessionFactory;
	 * insertValues("."); // addCheckSum(); }
	 * 
	 *//**
		 * Adds the to database when any new csv files or folder containing csv
		 * files added to the directory.
		 *
		 * @param fileName
		 *            the file name is the name of the csv file or the name of
		 *            the airways as well
		 * @throws UserExceptionClass
		 *             the user exception class for handling custom exceptions
		 */
	/*
	 * public static void addToDatabase(final String fileName) throws
	 * UserExceptionClass { insertValues(fileName); }
	 * 
	 *//**
		 * Delete from the database when any new csv files or folder containing
		 * csv files deleted to the directory..
		 *
		 * @param fileName
		 *            the file name is the name of the csv file or the name of
		 *            the airways as well
		 */
	/*
	 * public static void deleteFromDatabase(final String fileName) {
	 * deleteValues(fileName); }
	 * 
	 *//**
		 * Delete values delete using the session object and session object is
		 * matched to the name of the file that is csv and it is the primary key
		 * in the mapping class flight names.
		 *
		 * @param fileName
		 *            the file name is the name of the csv file or the name of
		 *            the airways as well
		 *//*
		 * public static void deleteValues(final String fileName) { final
		 * Session sesion = sessionFactory.openSession();
		 * sesion.beginTransaction(); final FlightName flight = (FlightName)
		 * sesion.load(FlightName.class, fileName.replaceAll(".csv", ""));
		 * sesion.delete(flight); sesion.getTransaction().commit(); }
		 */
}
