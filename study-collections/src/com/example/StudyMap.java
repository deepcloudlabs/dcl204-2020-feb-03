package com.example;

import java.util.Map;
import java.util.TreeMap;

/**
 * 
 * @author Binnur Kurt <binnur.kurt@gmail.com>
 *
 */
public class StudyMap {

	public static void main(String[] args) {
		Map<String,Integer> areaCodes = new TreeMap<>();
		areaCodes.put("istanbul-anadolu", 216);
		areaCodes.put("ankara", 312);
		areaCodes.put("istanbul-avrupa", 212);
		System.out.println(areaCodes.get("ankara"));
		System.out.println(areaCodes.size());
		for (String city : areaCodes.keySet()) {
			System.out.println(city);
		}
		for (Integer code : areaCodes.values()) {
			System.out.println(code);
		}
		for (Map.Entry<String, Integer> pair : areaCodes.entrySet()) {
			System.out.println(pair.getKey()+": "+pair.getValue());
		}
	}

}
