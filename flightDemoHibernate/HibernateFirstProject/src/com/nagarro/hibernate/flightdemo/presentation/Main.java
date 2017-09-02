package com.nagarro.hibernate.flightdemo.presentation;

import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.nagarro.hibernate.flightdemo.services.ExceptionManager;
import com.nagarro.hibernate.flightdemo.services.SessionManager;

// TODO: Auto-generated Javadoc
/**
 * The Class Main.
 */
public class Main {

	/**
	 * The main method.
	 *
	 * @param args the arguments
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub

		System.out.println("WELCOEME");

		/*HashMap<String, ArrayList<FlightDetails>> fileMapper = new HashMap<String, ArrayList<FlightDetails>>();

		fileMapper = FilterCSVFile.filterCSVFile(".");

	*/	// int i=0;
		SessionFactory sessionFactory = new Configuration().configure().buildSessionFactory();
		//SessionManager session=new SessionManager(sessionFactory);
		SessionManager.createSchema(sessionFactory);
		UserInput.logInitialization();
		ExceptionManager.handleException();
		//SessionManager.manageSessions(sessionFactory);
		/*Session session=null;
		Transaction transaction=null;

		try {
			session = sessionFactory.openSession();
			transaction=session.beginTransaction();
			Set<String> s = fileMapper.keySet();
			String[] array = s.toArray(new String[s.size()]);

			for (int i = 0; i < fileMapper.size(); i++) {

				final ArrayList<FlightDetails> flightList = new ArrayList<FlightDetails>();
				FlightNames fn = new FlightNames();

				flightList.addAll(fileMapper.get(array[i]));
				fn.setAirways(array[i]);
				// session.save(fn);

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
						// SessionFactory sessionFactory = new
						// Configuration().configure().buildSessionFactory();
						
						 * session = sessionFactory.openSession();
						 * session.beginTransaction();
						 
						flightDetails.setAirwaysName(fn);
						session.saveOrUpdate(flightDetails);

						// session.getTransaction().commit();

					} catch (HibernateException e) {
						// TODO Auto-generated catch block
						// e.printStackTrace();
						//System.out.println("Yee Handleds");
						transaction.rollback();
						
						
					}

				}

				session.saveOrUpdate(fn);
				
			}
			
			
			session.getTransaction().commit();
			System.out.println("Ok done");
			@SuppressWarnings("resource")
			final Scanner scanner = new Scanner(System.in);			
			 // flightDetails=null; s
			Session sesion = sessionFactory.openSession();
			  sesion.beginTransaction(); //flightDetails=(FlightDetails)
			 // sesion.get(FlightDetails.class,"AI277");
			  String y=scanner.nextLine();
			  if(y.equals("y")){
					FlightNames fnd=(FlightNames) sesion.load(FlightNames.class, "Indigo");
					sesion.delete(fnd);
				}
				
			  //System.out.println(flightDetails.getFlightClass());
			 // session.save(flightDetails); 
			  sesion.getTransaction().commit();
		} catch (HibernateException e) {
			// TODO Auto-generated catch block
			System.out.println("Yee Handleds");
		}*/
		 

		/*
		 * try {
		 * 
		 * session = sessionFactory.openSession(); session.beginTransaction();
		 * FlightNames fn=new FlightNames(); fn.setAirways("name");
		 * fn.setFlightList(flightList);
		 * 
		 * session.save(fn); session.getTransaction().commit(); } catch
		 * (HibernateException e) { // TODO Auto-generated catch block
		 * e.printStackTrace(); }
		 */

	}

}