package com.example;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

/**
 * 
 * @author Binnur Kurt <binnur.kurt@gmail.com>
 *
 */
public class StudyList {

	public static void main(String[] args) {
		// Ordered, Duplicate
		ArrayList<Integer> numbers = new ArrayList<>();
		numbers.add(4);
		numbers.add(42);
		numbers.add(8);
		numbers.add(4);
		numbers.add(15);
		numbers.add(4);
		numbers.add(23);
		numbers.add(16);
		System.out.println(numbers);
		System.out.println(numbers.size());
		System.out.println(numbers.get(0));
		System.out.println(numbers.get(7));
		System.out.println(numbers.get(numbers.size()/2));
		Collections.sort(numbers);
		System.out.println(numbers);
		Collections.sort(numbers,(x,y)->y-x);
		System.out.println(numbers);
		Comparator<Integer> ascOrder = 
				Integer::compare;
		Comparator<Integer> descOrder = 
				ascOrder.reversed();
		Collections.sort(numbers,descOrder);
		System.out.println(numbers);
		while(numbers.remove(Integer.valueOf(4)));
		System.out.println(numbers);
		System.out.println(numbers.contains(4));
	}

}
