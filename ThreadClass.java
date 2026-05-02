package example.features.java8;

public class ThreadClass {
	
	public static void main(String args[]) throws InterruptedException {
		System.out.println("Inside the main class ");
		Thread t1= new Thread(new SampleThreadWithRunnable(),"RunnableThread"); //Thread(ObjectOfRunnableInterface) or along with the name of the Thread. 
		t1.start();
		t1.join(); //now t1 spread executes whi;e the main thread waits. 
		Thread t2= new Thread(new SampleThreadWithRunnable()); //Thread(ObjectOfRunnableInterface) or along with the name of the Thread. 
		t2.start();
		
		/* In the above example, the two threads are created and started. 
		 * Now, it is upto the JVM to run the thread in its own order.
		 * 
		 * */
		
				

}
}
