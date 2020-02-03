package com.example;

/**
 * 
 * @author Binnur Kurt <binnur.kurt@gmail.com>
 *
 */
public class StudyChar {

	public static void main(String[] args) {
		char x = 'a'; // 2-byte, unicode
		x++;
		System.out.println(x);
		System.out.println(x + 0);
		x = '\u20BA';
		System.out.println(x);

	}

}
