package example.features.java8;

import java.util.List;
import java.util.Optional;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Predicate;
import java.util.function.Supplier;

public class Java8_Features implements SampleInterface {

	public static void main(String args[]) {
		
		//Lambda Expression. 
		System.out.println("Lambda Function ");
		int a=5;
		int b=2;
		FuncInterface c= (x,y)->x+y;
		//c.sum(a, b);
		System.out.println(" Sum of two numbers "+c.sum(a, b));
		
		FuncInterface c2 = (x, y) -> a * b;
		System.out.println(" Multiple of two numbers "+c2.sum(a, b));
		
		//Default Methods in Interface 
		Java8_Features j8 = new Java8_Features();
		j8.hiThereMethod(); //called the overridden method here. 
		j8.aDefaultMethod(); //called the default method here. 

		SampleInterface.staticMethod(); //called the static method in the Interface.
		
		 
		/*Predicate<T> 
		 * 
		 * Accepts one variable T and give a boolean result only. 
		 * It has one method signature: boolean test(T t)
		 * 
		 * 
		 * */
		Predicate<Integer> h=j->j>0;
		System.out.println("Predicate result here "+h.test(32));
		
		/*Function<T,R>
		 * 
		 * Accepts one Variable T and returns a result R
		 * It has R apply(T)
		 * 
		 * T is input parameter. 
		 * R is Return type. 
		 * 
		 * */
		Function<String,Integer> i=s->{return s.length();};
		System.out.println("Function result here "+ i.apply("Function is a functional interface"));
		
		/*
		 * Consumer<T>
		 * 
		 * Accepts one variable T and does operation but returns nothing. 
		 * It has void accept(T)
		 * 
		 * T is input paramter.
		 * 
		 * */
		Consumer<String> k=c3->System.out.println("Working with consumer functional interface"+c3);
		k.accept("test");
		
		/*
		 * Supplier<R>
		 * 
		 * It doesn't accept any parameter but returns R
		 * It has R get()
		 * 
		 * R is the return type. 
		 * */
		Supplier<String> v=()->{return "Supplier passed...";};
		System.out.println(v.get());

		/*
		 * BiPredicte is similar to Predicate but it will accept two input parameters. BiPredicate<T t, U u> . boolean test<T,U>
		 * 
		 * BiFunction is similar to Function but it will accept two input parameter. BiFunction<T t, U u, R r> . R apply<T,U>
		 * 
		 * BiConsumer is similar to Consumer but it will accept two input parameter. BiConsumer<T t, U u> . void accept<T,U>
		 * 
		 * 
		 * */
		
		/*
		 * Optional container/wrapper that either contains a value or doesn’t. Thus helping in the avoiding the null pointer exception.
		 * There are 3 ways to create the Optional values. 
		 * */
		Optional<String> optVariable= Optional.of("Hello there!!!"); // Use only when you are 100% sure it’s non-null
		System.out.println("Optional.of  In Java 8 "+optVariable);
		
		
		Optional<String> optVariable1= Optional.ofNullable("HHEYEUEIEO"); // Used when the value might be null. Returns the value if not null, returns "Optional.Empty" if null 
		System.out.println("Optional.ofNullable  In Java 8 "+optVariable1);
		
		Optional<String> optVariable2= Optional.empty(); // Use only when it is explicitly no value. 
		System.out.println("Optional.empty  In Java 8 "+optVariable2);
		
		
		optVariable2.ifPresent(k1->{System.out.println("IfPresent code for Optional.ofNullable ");}); 
		//This s.o.p is executed only if the value is present. If null, this s.o.p is not executed. This ifPresent accepts the consumer. 
		optVariable1.isPresent(); // Returns true if a value is present
		
		/*
		 * optionalVariable.OrElse(String value), if optionalVariable is null, then String value will be returned. 
		 * */
		System.out.println(optVariable.orElse("If it is empty so default value will be printed... "));
		
		/*
		 * optionalVariable.OrElse(), if optionalVariable is null, then result of Supplier is executed.
		 * */
		System.out.println(optVariable.orElseGet(()-> "OrElseGet is called is executed.. "));
		
		/*
		 * optionalVariable.OrElseThrow(), if optionalVariable is null, then exception will be thrown. 
		 * Below example is custom exception thrown. 
		 * WHile we can also have optVariable1.orElseThrow() which will give NoSuchElementException. 
		 * */
		System.out.println(optVariable1.orElseThrow(
				()->new IllegalArgumentException("Null value spotted.")
				));

		
		/*
		 * map() method:
		 *  value inside the Optional, if it is present. 
		 *  It transforms the value inside the Optional and returns a new Optional containing the transformed value.
		 *  Else it returns empty optional
		 * */
		System.out.println("Map Function in Optional "+optVariable2.map(String::toLowerCase));
		
		/*
		 * flatMap() method:
		 * used when the function applied to the value inside the Optional returns another Optional.
		 * */
		System.out.println("FlatMap example "+optVariable1.flatMap(
				z->Optional.of(z.length())));

		/*
		 * filter() method
		 * used to test the value inside the Optional against a condition (predicate).
		 * If the value satisfies the condition, filter() returns the original Optional. If the value does not satisfy the condition, 
		 * filter() returns an empty Optional. If the Optional is already empty, filter() does nothing and returns an empty Optional.
		 * */
		System.out.println("Filter condition applied "+
				optVariable1.filter(x->x.length()>2));
		

		Optional<List<String>> optVariableList= Optional.of(List.of("1","2","3")); // Use only when you are 100% sure it’s non-null

	}

	//Own Implementation for SampleInterface
	
	@Override
	public void hiThereMethod() {
		System.out.println("Added Own Implementation for the method in SampleInterface ");
		
	}
	
	
//	@Override
//	public String aDefaultMethod() {
//		System.out.println("Overridding the default method here!!!");
//		return "Overridding the aDefaultMethod() from the SampleInterface!!!";
//	}
	
}
