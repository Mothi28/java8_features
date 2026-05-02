package example.features.java8;

public class ThreadForSync {
	
	public static void main(String args[]) {
		CustomThread t1 = new CustomThread(4);
		CustomThread t2 = new CustomThread(5);
		
		t1.start();
		t2.start();
		
//		try {
//			t1.join();
//		} catch (InterruptedException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}
	}

}
