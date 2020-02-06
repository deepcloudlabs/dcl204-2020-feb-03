package com.example;

/**
 * 
 * @author Binnur Kurt <binnur.kurt@gmail.com>
 *
 */
@SuppressWarnings("finally")
public class CatchMeIfYouCan {
	public static int fun() {
		try {
			return 42;
		} finally {
			return 108;
		}
	}

	public static void main(String[] args) {
		System.out.println(fun());
		// a) 42
		// b) 108
		// c) 75
		// d) does not compile!
	}

}
