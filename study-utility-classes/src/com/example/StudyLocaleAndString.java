package com.example;

import java.util.Locale;

/**
 * 
 * @author Binnur Kurt <binnur.kurt@gmail.com>
 *
 */
public class StudyLocaleAndString {

	public static void main(String[] args) {
		Locale tr = new Locale("tr");
		String city = "izmir"; // Immutable
		String upperCity = city.toUpperCase(tr);
		System.out.println(city);
		System.out.println(upperCity);

	}

}
