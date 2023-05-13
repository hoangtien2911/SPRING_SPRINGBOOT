package programing;

import java.util.List;

public class FP01Functional {
	public static void main(String[] args) {
		List<Integer> numbers = List.of(1, 3, 4, 5, 6);
//		printAllNumberInListStructured(numbers);
		printEvenNumberInListStructured(numbers);
	}
	
	private static void print(int number) {
		System.out.println(number);
	}

	private static void printAllNumberInListStructured(List<Integer> lists) {
//		[1, 3, 4, 5, 6]
		//1 
		//3
		//4
		//5
		//6
		//Convert list of stream
		lists.stream().forEach(FP01Functional::print);//Method reference
		
		lists.stream().forEach(System.out::println);//Method reference
//		for (Integer list : lists) {
//			System.out.println(list);
//		}
//		
	}
	
//	private static boolean isEven(int number) {
//		return number % 2 == 0;
//	}
	
	
	//number -> number % 2 == 0
	private static void printEvenNumberInListStructured(List<Integer> lists) {
		lists.stream()
		//Filter - Only allow even number
//		.filter(FP01Functional::isEven)
		.filter(number -> number % 2 == 0) //Lamdba Expression
		//mapping x -> x * x
		.map(number -> number * number)
		.forEach(System.out::println);//Method reference

	}
}
