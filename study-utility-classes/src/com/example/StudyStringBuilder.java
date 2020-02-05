package com.example;

/**
 * 
 * @author Binnur Kurt <binnur.kurt@gmail.com>
 *
 */
public class StudyStringBuilder {
	public static void main(String[] args) {
		System.out.println("Started!");
		long start = System.currentTimeMillis();
		StringBuffer s = new StringBuffer(788888890);
		for (int i = 0; i < 100_000_000; ++i) {
			s.append(Integer.toString(i));
		}
		long stop = System.currentTimeMillis();
		System.out.println(s.length() + " @ " + (stop - start) + " ms.");
	}
}
