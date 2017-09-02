// This class is dealing with the thread implementation of Truck and their getter and setter functions. 


package Assignment4;

	class Run extends Thread {
		
		public int truck_ID;
		public int truck_axle;
		public double truck_weight;
		
		
		public void run() {
			
			//System.out.println("______________Truck is on Road._________________");
						 
			try {
				Thread.sleep(1000);                            // Thread will die in 1 second
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		
			
			 super.run();
		}

 // Getter and Setter methods for the above thread.
		public int getTruck_ID() {
			return truck_ID;
		}


		public void setTruck_ID(int truck_ID) {
			this.truck_ID = truck_ID;
		}


		public int getTruck_axle() {
			return truck_axle;
		}


		public void setTruck_axle(int truck_axle) {
			this.truck_axle = truck_axle;
		}


		public double getTruck_weight() {
			return truck_weight;
		}


		public void setTruck_weight(double truck_weight) {
			this.truck_weight = truck_weight;
		}
		
	}	
		