package scale;

import adapter.*;

public class EditOptions extends ProxyAutomobile implements ScaleThread, Runnable {
	private Thread thread;
	private int ops;
	private String [] name;
	// String [0] Model/oldModelName, String [1] newModelName, String [2] Name/oldName,
	// String [3] newName, String [4] newPrice = double
	
	public EditOptions() {
		thread = new Thread(this);
		name = new String[5];
		start();
	}
	
	public EditOptions(int Ops, String [] Name) {
		thread = new Thread(this);
		ops = Ops;
		name = Name;
		start();
	}
	
	// String [0] Model/oldModelName, String [1] newModelName, String [2] Name/oldName,
	// String [3] newName, String [4] newPrice = double
	public void run() {
		switch(ops) {
		case 0:
			this.updateModelName(name[0], name[1]);
			System.out.printf("Finished updating model name\n");
			stop();
			break;
			
		case 1:
			System.out.printf("Finished updating option name\n");
			this.updateOptionName(name[0], name[2], name[3]);
			System.out.printf("Finished updating\n");
			stop();
			break;
			
		case 2:
			double newPrice = Double.parseDouble(name[4]);
			this.updateOptionPrice(name[0], name[2], newPrice);
			System.out.printf("Finished updating option price\n");
			stop();
			break;
			
		default:
			break;
		}
	}
	
	public void start() {
//		try {
//			System.out.printf("It's working\n");
//			thread.sleep(2000);
//		Thread.sleep(2000);
			thread.start();
//		} catch(InterruptedException e) {
//			e.getMessage();
//		}	
	}
	
	public void stop() 	{
//		thread.stop();
		thread = null;
		System.out.printf("Stop\n");
	}
	
	public synchronized void updateModelName(String oldModelName, String newModelName) {
		super.updateModelName(oldModelName, newModelName);

		try {
			Thread.sleep(2000);
//			System.out.printf("Update Model Name is running\n");
		} catch(InterruptedException e) {
			
		}
		super.printFleet();
//		notifyAll();
	}
	
	public synchronized void updateOptionName(String Model, String oldName, String newName) {
		super.updateOptionName(Model, oldName, newName);
		
		try {
			Thread.sleep(2000);
			System.out.printf("Update Option Name is running\n");
		} catch(InterruptedException e) {
		
		}
		super.printFleet();
//		notifyAll();
	}
	
	public synchronized void updateOptionPrice(String Model, String Name, double newPrice) {
		super.updateOptionPrice(Model, Name, newPrice);
		
		try {
			Thread.sleep(2000);
			System.out.printf("Update Option price is running\n");
		} catch(InterruptedException e) {
		
		}
		super.printFleet();
//		notifyAll();
	}
	
}
