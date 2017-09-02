// This class is dealing with the thread implementation of TollBooths and their getter and setter functions. 


package Assignment4;

 class Toll extends Thread {
	 
	
	protected int TollBooth_ID;          // Both getter and Setter methods used 
	protected double TollBooth_cash;	 // Both getter and Setter methods used 
	protected Boolean TollBooth_Status;   // Both getter and Setter methods used 
	
	public void run() {
		
		//System.out.println("TollBooth is Active.");
		 
		try {
			Thread.sleep(1000);                            // Thread will die in 1 second
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	
		
		 super.run();
	}
		
	
	protected int getTollBooth_ID() {
		return TollBooth_ID;
	}
	protected void setTollBooth_ID(int tollBooth_ID) {
		TollBooth_ID = tollBooth_ID;
	}
	protected double getTollBooth_cash() {
		return TollBooth_cash;
	}
	protected void setTollBooth_cash(double tollBooth_cash) {
		TollBooth_cash = tollBooth_cash;
	}
	protected Boolean getTollBooth_Status() {
		return TollBooth_Status;
	}
	protected void setTollBooth_Status(Boolean tollBooth_Status) {
		TollBooth_Status = tollBooth_Status;
	}
		
}
