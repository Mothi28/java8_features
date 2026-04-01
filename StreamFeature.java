package example.features.java8;

import java.util.Arrays;
import java.util.Collection;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class StreamFeature {

	public static void main(String args[]) {

		// Creating streams using Stream.of
		Stream<String> s = Stream.of("1", "2", "3");
		System.out.println("Elements present inside the Streams with Stream.of ");
		s.filter(e -> e.equalsIgnoreCase("3")).forEach(System.out::println);

		// Creating streams using Stream() with List<Integer>
		System.out.println("Elements present inside the Streams created with List<Integer> ");
		List<Integer> numberList = Arrays.asList(4, 5, 6, 8);
		Stream<Integer> i = numberList.stream();
		i.filter(f -> f >= 5).forEach(System.out::println);

		// Creating streams using Stream.ofNullable() with Float
		System.out.println("Elements present inside the Streams created Stream.ofNUllable ");
		Stream<Float> f = Stream.ofNullable(19.8f);
		f.forEach(System.out::println);

		// Creating empty stream using Stream.empty() with Float
		System.out.println("Streams created Stream.empty ");
		Stream<Float> g = Stream.empty();
		g.forEach(System.out::println);

		// Creating streams using Stream.generate().
		/*
		 * This Stream.generate() needs Supplier. S0, lambda function is given. This
		 * generate gives infinite value so, the condition is stopped by given "limit"
		 */
		System.out.println("Streams created using Stream.generate() ");
		Stream<Integer> g1 = Stream.generate(() -> {
			return 1;
		}).limit(10);
		g1.forEach(System.out::println);

		// Creating streams using Stream.iterate().
		/*
		 * This Stream.iterate() needs seed value and operator. This generate gives
		 * infinite value so, the condition is stopped by given "limit"
		 */
		System.out.println("Streams created using Stream.iterate() ");
		Stream<Integer> h = Stream.iterate(33, n -> n + 2).limit(5);
		h.forEach(System.out::println);

		// Converting a stream to collection using collect(Collectors.toList()); method.
		Stream<String> s1 = Stream.of("1", "2", "3");
		System.out.println("Converting the stream to collection " + s1.collect(Collectors.toList()));
		// s1.forEach(null)

		/*
		 * Filter + Map + Collect
		 * 
		 * You are given a List<String> of employee names. Return a List<String> of
		 * names:
		 * 
		 * that start with "A"
		 * 
		 * converted to uppercase
		 * 
		 * sorted alphabetically
		 */

		List<String> empName = List.of("Mothi", "Vicky", "Kishore", "Ashok", "Abi");
		System.out.println(
				"EMp name list... " + empName.stream().filter(empNameFromList -> empNameFromList.startsWith("A"))
						.map(String::toUpperCase).sorted().collect(Collectors.toList()));
		// Stream<String> empNameStream =
		// empName.stream().filter(empNameFromList->empNameFromList.startsWith("A")).map(String::toUpperCase).sorted();

		List<Integer> num = List.of(1, 2, 3, 4, 5, 5, 6, 7, 2);
		System.out.println("The Distinct List of numbers... " + num.stream().distinct().collect(Collectors.toSet()));

		// ["java", "spring", "java"]
		/*
		 * List<String> courses = List.of("java", "spring", "java"); List<String>
		 * courseCopy = courses; Map<String,Long> courMap = new HashMap<>(); int
		 * count=0; for(String c:courses) { if(courseCopy.contains(c)) { count++; }
		 * courMap.put(c,(long) count); } System.out.println("Couse Map "+courMap);
		 * 
		 */
		// old school way.
		List<Integer> w = List.of(10, 2, 15, 3);
		System.out.println(
				"Second Highest Number to find " + w.stream().sorted().collect(Collectors.toList()).get(w.size() - 2));
		// .get(w.size()-1));

		// Optimum way to find the second largest number in the list
		Optional<Integer> sHn = w.stream().distinct().sorted(Comparator.reverseOrder()).skip(1).findFirst();
		sHn.ifPresentOrElse(x -> {
			System.out.println("Second Largest Number is " + sHn);
		}, () -> {
			System.out.println("No second Largest Number !!");
		});
		
		//Return emp names without blank or spaces. 
		List<String> empName1 = List.of("Mothi", "", "Kishore", "Ashok", "Abi"," ");
		empName1.stream().filter(i1->!i1.isBlank()&&!i1.isEmpty()).forEach(System.out::println);
		
		//Group employee by department... 
		List<Employee> employees = List.of(
			    new Employee("Mothi", "IT", 60000),
			    new Employee("Kishore", "HR", 45000),
			    new Employee("Ashok", "IT", 75000),
			    new Employee("Abi", "Finance", 50000),
			    new Employee("Vicky", "HR", 55000)
			);
		

		Map<String, List<String>> h1 = employees.stream()
				.collect(Collectors.groupingBy(Employee::getDepartment, Collectors.mapping(Employee::getName, Collectors.toList())));
		
		
		
		System.out.println(h1);
		
		Map<String, List<String>> j1=employees.stream()
				.collect(Collectors.groupingBy(Employee::getDepartment,Collectors.mapping(Employee::getName, Collectors.toList())));  //this gives the depart and name of the employee alone.
		
		//employees.stream().collect(Collectors.groupingBy(Employee::getDepartment)); till this the grouping is done but the List<Employee> is returned.
	
		System.out.println("Grouping by Depart "+j1);
						
		Map<String, Long> j2=employees.stream()
				.collect(Collectors.groupingBy(Employee::getDepartment,Collectors.counting()));
		
		System.out.println("Grouping by Depart and count "+j2); //this gives the grouping by department and the counting
		
		Map<String, Double> j3=employees.stream()
				.collect(Collectors.groupingBy(Employee::getDepartment,Collectors.averagingDouble(Employee::getSalary)));
		
		System.out.println("Grouping by Depart and average of salary in DOuble "+j3); //this gives the grouping by department and the average in double.
		
		Map<String, Optional<Employee>> j4=employees.stream()
				//comparingDouble(Employee::getSalary)); //this gives the max salary in the Employee alone.
				.collect(Collectors.groupingBy(Employee::getDepartment,Collectors.maxBy(Comparator.comparingDouble(Employee::getSalary))));
		
		System.out.println("Grouping by Depart and Maximum salary in DOuble "+j4.toString()); //this gives the grouping by department and the maximum salary in double.
	
		Stream<Integer> j5 = Stream.of(45,2);
		System.out.println("Reduce operation without identity "+j5.reduce((a, b) -> a * b)); // as values are present in the stream, the result will be multiplication.
		
		Stream<Integer> j6 = Stream.empty();
		System.out.println("Reduce operation with identity value "+j6.reduce(56,(a, b) -> a * b)); // as Stream is empty, the result will be 56 the identity value. 
		
	}

}
