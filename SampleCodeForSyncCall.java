package example.features.java8;

public class SampleCodeForSyncCall {
	
	    public static void main(String[] args){
	        
	    	
	    	/*
	    	 * three types of synchronized-> synchronized method, synchronized block and static synchronization.
	    	 * Synchronization makes sure that only one thread access the shared resource (variable, Object or method) at a time. 
	    	 * Thus preventing the concurrent threads from interfering with each other while modifying shared data. 
	    	 *  
	    	 * */
	    	
	        // Shared resource
	        Counter cnt = new Counter(); 

	        Thread t1 = new Thread(() -> {
	            for (int i = 0; i < 5; i++)
	                cnt.inc();
	        });

	        Thread t2 = new Thread(() -> {
	            for (int i = 0; i < 5; i++)
	                cnt.inc();
	        });

	        t1.start();
	        t2.start();

	        try {
	            t1.join();
	            t2.join();
	        }
	        catch (InterruptedException e) {
	            e.printStackTrace();
	        }

	        System.out.println("Counter: " + cnt.get());
	    }
	}
