package programing;

import java.util.List;

public class FP01Structured {
	public static void main(String[] args) {
		List<Integer> numbers = List.of(1, 3, 4, 5, 6);
		printAllNumberInListStructured(numbers);
		printEvenNumberInListStructured(numbers);
	}

	private static void printAllNumberInListStructured(List<Integer> lists) {
		for (Integer list : lists) {
			System.out.println(list);
		}

	}

	private static void printEvenNumberInListStructured(List<Integer> lists) {
		for (Integer list : lists) {
			if (list % 2 == 0)
				System.out.println(list);
		}

	}
}
