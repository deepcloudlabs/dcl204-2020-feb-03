package com.example.dictionary.exercises;

import static java.util.Comparator.comparing;

import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.List;

public class Exercise7 {

	public static void main(String[] args) throws Exception {
		final List<String> words = Files.readAllLines(Paths.get("src", "dictionary.txt"));
		// Find the longest word in the dictionary
		String longest1 = words.stream()
		     .sorted(comparing(String::length)
		    		   .reversed())
		     .findFirst()
		     .get();
		System.out.println(longest1);
		String longest2 = 
		   words.stream()
				.max(comparing(String::length)).get();
		System.out.println(longest2);
	}

}
