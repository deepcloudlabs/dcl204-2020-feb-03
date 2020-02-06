package com.example.service;

import java.lang.reflect.Field;
import java.util.List;
import java.util.concurrent.ThreadLocalRandom;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

import com.example.RandomNumber;

/**
 * 
 * @author Binnur Kurt <binnur.kurt@gmail.com>
 *
 */
public class RandomNumberService {
	public static void generateRandomNumbers(Object o) throws Exception {
		Class<?> clazz = o.getClass();
		for (Field field : clazz.getDeclaredFields()) {
			if (field.isAnnotationPresent(RandomNumber.class)) {
				RandomNumber rn = field.getAnnotation(RandomNumber.class);
				int min = rn.min();
				int max = rn.max();
				long size = rn.size();
				IntStream stream = ThreadLocalRandom.current().ints(min, max);
				if (rn.unique())
					stream = stream.distinct();
				stream = stream.limit(size);
				if (rn.sorted())
					stream = stream.sorted();
				List<Integer> numbers = stream.boxed().collect(Collectors.toList());
				field.setAccessible(true);
				field.set(o, numbers);
				field.setAccessible(false);
			}
		}
	}
}
