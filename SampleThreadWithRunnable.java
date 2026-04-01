package example.features.java8;

public class SampleThreadWithRunnable implements Runnable {

	/*
	 * Here a thread class is created by implementing the Runnable interface. 
	 * The run method is overridden here. */
	
	@Override
	public void run() {
		
		for(int i=0;i<4;i++) {
			System.out.println("Thread Name "+Thread.currentThread().getName()+" "+i);
		}
	}

}
