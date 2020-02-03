package com.example;

import java.util.Arrays;

/**
 * 
 * @author Binnur Kurt <binnur.kurt@gmail.com>
 *
 */
@SuppressWarnings("unused")
public class StudyArray {

	public static void main(String[] args) {
		int number = 42; // scalar
		Integer[] numbers = { 42, 8, 16, 23, 15, 4 }; // array
		System.out.println(numbers.length);
		System.out.println(numbers[3]);
//		System.out.println(numbers[-1]);
		Arrays.sort(numbers, (x, y) -> y - x);
		System.out.println(Arrays.toString(numbers));
		for (int i = 0; i < numbers.length; i += 2)
			System.out.println(numbers[i]++);
		for (int x : numbers) // read-only, sequential
			System.out.println(x);
		Arrays.stream(numbers).parallel().forEach(System.out::println);
	}

}
