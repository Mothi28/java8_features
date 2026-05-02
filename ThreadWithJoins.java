package example.features.java8;

public class ThreadWithJoins {

	public static void main(String args[]) {
		
		Thread t1 = new Thread(()->{System.out.println("Running the t1 thread");});
		Thread t2 = new Thread(()->{System.out.println("Running the t2 thread");});
		Thread t3 = new Thread(()->{System.out.println("Running the t3 thread");});

		
		t1.start();
		t2.start();
		t3.start();
		try {
			t1.join(); //Main thread waits till t1 thread finishes the execution. 
			t3.join(); //Main thread waits till t3 thread finishes the execution.
			
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			System.out.println("Main Thread interrupted ");
			e.printStackTrace();
		}
		
		//System.out.println("Thread t1 done running");
		System.out.println("Main thread resumes ");
	}
	
}
