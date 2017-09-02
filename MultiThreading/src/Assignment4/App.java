	// 1. Here I have used a random number generator to make the truck axles and weight random.
	// 2. With using setter method implemented in the truck.java, I have fixed all the constraints 
	//    of the Truck.
	// 3. After setting all constraints, I have displayed all details of the corresponding Truck. 

package Assignment4;

import java.util.Random;

public class App  {
	
	public static <TollBooth> void main(String[] args) throws Exception {
		
		double CashReceived1 =0;
		double CashReceived2 =0;
		double CashReceived3 =0;
		double CashReceived4 =0;
		
		Random randomGenerator = new Random();	
		
		System.out.println("\n~~~~~~~~~~~~WELCOME TO THE VISHWA TOLLBOOTH~~~~~~~~~~~~~~~~\n");
		
		//+++++++++++++++++++++++++++ Toll Booth Threads +++++++++++++++++++++++++++++++++++//
		// All booths needs to run simultaneously so these should be threads not methods.
		
		Toll TB1 = new Toll();
		TB1.start();
		
		
		Toll TB2 = new Toll();
		TB2.start();
		
		
		Toll TB3 = new Toll();
		TB3.start();
		
		
		Toll TB4 = new Toll();
		TB4.start();
				
	// ++++++++++++++++++++++++++++ Initiating Trucks using Threads ++++++++++++++++++++++++//
		
		for(int i=1; i<=10; i++){
		
		Run T1 = new Run ();
		T1.start();
		T1.setTruck_ID(i);
		T1.setTruck_axle(4 + 2*randomGenerator.nextInt(5));
		T1.setTruck_weight(50 + randomGenerator.nextInt(200));
		//Thread.sleep(100);
		
		

	
		Random random_number = new Random();
		int temp = 1+ random_number.nextInt(4);  // Random Number generation to select random TollBooth.
		
		if(temp == 1 ){
			TB1.setTollBooth_ID(1);
			TB1.setTollBooth_Status(true);
			System.out.println("Truck ID: " + T1.getTruck_ID()+ "\nNo. of axles: " + T1.getTruck_axle()+"\nTruck Weight: "+ T1.getTruck_weight());
			double temp1 = 5* T1.getTruck_axle() + 20* T1.getTruck_weight();
			Thread.currentThread();
			Thread.sleep(100);
			CashReceived1 = CashReceived1 + temp1;
			TB1.setTollBooth_cash(CashReceived1);
			System.out.println("TollBooth ID: "+TB1.getTollBooth_ID());
			System.out.println("Cash Received from TruckID- "+ T1.getTruck_ID() + " is: " +temp1 );
			System.out.println("Cash in Drawer 1: " + TB1.getTollBooth_cash()+"\n\n");
			
			
			TB1.setTollBooth_Status(false);
			Thread.currentThread();
			Thread.sleep(500);
			
		}
			
		else if (temp == 2 ) {
			TB2.setTollBooth_ID(2);
			TB2.setTollBooth_Status(true);
			System.out.println("Truck ID: " + T1.getTruck_ID()+ "\nNo. of axles: " + T1.getTruck_axle()+"\nTruck Weight: "+ T1.getTruck_weight());
			double temp1 = 5* T1.getTruck_axle() + 20* T1.getTruck_weight();
			Thread.currentThread();
			Thread.sleep(100);
			CashReceived2 = CashReceived2 + temp1;
			TB2.setTollBooth_cash(CashReceived2);
			System.out.println("TollBooth ID: "+TB2.getTollBooth_ID());
			System.out.println("Cash Received from TruckID- "+ T1.getTruck_ID() + " is: " +temp1 );
			System.out.println("Cash in Drawer 2: " + TB2.getTollBooth_cash()+"\n\n");
			
			
			TB2.setTollBooth_Status(false);
			Thread.currentThread();
			Thread.sleep(500);
		}
		else if (temp ==3) {
			TB3.setTollBooth_ID(3);
			TB3.setTollBooth_Status(true);
			System.out.println("Truck ID: " + T1.getTruck_ID()+ "\nNo. of axles: " + T1.getTruck_axle()+"\nTruck Weight: "+ T1.getTruck_weight());
			double temp1 = 5* T1.getTruck_axle() + 20* T1.getTruck_weight();
			CashReceived3 = CashReceived3 + temp1;
			Thread.currentThread();
			Thread.sleep(100);
			TB3.setTollBooth_cash(CashReceived3);
			System.out.println("TollBooth ID: "+TB3.getTollBooth_ID());
			System.out.println("Cash Received from TruckID- "+ T1.getTruck_ID() + " is: " +temp1 );
			System.out.println("Cash in Drawer 3: " + TB3.getTollBooth_cash()+"\n\n");
			
			
			TB3.setTollBooth_Status(false);
			Thread.currentThread();
			Thread.sleep(500);
		}
		else if (temp == 4) {
			
			TB4.setTollBooth_ID(4);
			TB4.setTollBooth_Status(true);
			System.out.println("Truck ID: " + T1.getTruck_ID()+ "\nNo. of axles: " + T1.getTruck_axle()+"\nTruck Weight: "+ T1.getTruck_weight());
			double temp1 = 5* T1.getTruck_axle() + 20* T1.getTruck_weight();
			Thread.currentThread();
			Thread.sleep(100);
			CashReceived4 = CashReceived4 + temp1;
			TB4.setTollBooth_cash(CashReceived4);
			System.out.println("TollBooth ID: "+TB4.getTollBooth_ID());
			System.out.println("Cash Received from TruckID- "+ T1.getTruck_ID() + " is: " +temp1 );
			System.out.println("Cash in Drawer 4: " + TB4.getTollBooth_cash()+"\n\n");
			
			
			TB4.setTollBooth_Status(false);
			Thread.currentThread();
			Thread.sleep(500);
		}
				
		}
		System.out.println("CashDrawer = 1: " + TB1.getTollBooth_cash());
		System.out.println("CashDrawer = 2: " + TB2.getTollBooth_cash());
		System.out.println("CashDrawer = 3: " + TB3.getTollBooth_cash());
		System.out.println("CashDrawer = 4: " + TB4.getTollBooth_cash());
		
	}
}

