package com.example;

import java.util.concurrent.ThreadLocalRandom;

/**
 * 
 * @author Binnur Kurt <binnur.kurt@gmail.com>
 *
 */
public class LotteryExample {

	public static void main(String[] args) {
		ThreadLocalRandom.current()
		    .ints(1, 50)
		    .distinct()
		    .limit(6)
		    .sorted()
		    .forEach(System.out::println);
	}

}
