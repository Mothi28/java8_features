package example.features.java8;

public class Counter {

	    
	    // Shared variable
	    private int c = 0; 

	    // Synchronized method to increment counter
	    public void inc(){ //"synchronized" keyword need to be put in front of the return type for synchronized method. 
	    	synchronized(this) { c++; } //this is an example of the synchronized block. This helps in better performance when compared to synchronized method.
	        
	    }

	    // Synchronized method to get counter value
	    public synchronized int get(){
	        return c; 
	        
	    }
	}
	

