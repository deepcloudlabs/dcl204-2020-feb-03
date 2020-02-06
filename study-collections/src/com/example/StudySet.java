package com.example;

import java.util.Comparator;
import java.util.Set;
import java.util.TreeSet;

/**
 * 
 * @author Binnur Kurt <binnur.kurt@gmail.com>
 *
 */
public class StudySet {

	public static void main(String[] args) {
		// Unordered, Unique
		Comparator<? super Integer> ascOrder = Integer::compare;
		Set<Integer> numbers = new TreeSet<>(ascOrder.reversed());
		numbers.add(4);
		numbers.add(42);
		numbers.add(8);
		numbers.add(4);
		numbers.add(15);
		numbers.add(4);
		numbers.add(23);
		numbers.add(16);
		System.out.println(numbers.contains(4));
		System.out.println(numbers.size());
		System.out.println(numbers);

	}

}
