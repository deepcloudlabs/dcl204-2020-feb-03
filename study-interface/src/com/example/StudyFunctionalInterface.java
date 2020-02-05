package com.example;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * 
 * @author Binnur Kurt <binnur.kurt@gmail.com>
 *
 */
public class StudyFunctionalInterface {

	public static void main(String[] args) {
		List<Integer> numbers = new ArrayList<>();
		numbers.addAll(Arrays.asList(1, 2, 3, 4, 5, 6));
		int total = numbers.stream().filter(t -> t % 2 == 1).mapToInt(x -> x * x).reduce(0, Integer::sum);
		System.out.println(total);
	}

}
