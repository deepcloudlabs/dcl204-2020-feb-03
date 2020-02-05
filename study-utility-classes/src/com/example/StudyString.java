package com.example;

/**
 * 
 * @author Binnur Kurt <binnur.kurt@gmail.com>
 *
 */
public class StudyString {

	public static void main(String[] args) {
		String s1 = "Jack"; // Constant Pool (Cache)
		String s2 = "Jack";
		String s3 = new String("Jack"); // Heap
		String s4 = new String("Jack"); // Heap
		System.out.println(s1==s2);
		System.out.println(s3==s4);
	}

}
