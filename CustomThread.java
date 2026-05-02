package example.features.java8;

public class CustomThread extends Thread{
	
	
	public int toCount;
	int sum = 0;
	
	public CustomThread() {
		//super();
	}

	public CustomThread(int c) {
		this.toCount = c;
	}

	@Override
	public void run() {
		//call synchronized method
		System.out.println("Counter is incremented by one "+ countingMethod(toCount));
	}
	
	public synchronized int countingMethod(int g) {
		
		for(int u=1;u<=g;u++) {
			sum=sum+u;
		}
		
		return sum;
	}

}
