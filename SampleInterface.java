package example.features.java8;


public interface SampleInterface {

	void hiThereMethod();
	
	default String aDefaultMethod() {
		
		System.out.println("Inside the default method class ");
		return "It is a default method from the SampleInterface Classs";
	}
	
	static void staticMethod() {
		System.out.println("This is a static method block... ");
	}
	
	//main method in Interface
	static void main (String args[]) {
		System.out.println("static void main method in the Interface"); 
	}
}
