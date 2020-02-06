package com.example.exercises;

import static java.util.stream.Collectors.groupingBy;
import static java.util.stream.Collectors.maxBy;

import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.stream.Collectors;

import com.example.dao.CountryDao;
import com.example.dao.InMemoryWorldDao;
import com.example.domain.Country;

/**
 * 
 * @author Binnur Kurt <binnur.kurt@gmail.com>
 *
 */
public class Exercise2 {
	private static final CountryDao countryDao = InMemoryWorldDao.getInstance();

	public static void main(String[] args) {
		// Find the most populated country of each continent
		Comparator<Country> compareByPopulation = 
			(c1,c2)->
		      c1.getPopulation()-c2.getPopulation();
		Map<String,Optional<Country>> mostPopulatedCountryByContinent = 
				countryDao.findAllCountries()
		          .stream()
		          .collect(
		        	  groupingBy(Country::getContinent,
		        	  maxBy(compareByPopulation))
		          );
		mostPopulatedCountryByContinent.forEach(
				(continent,country) ->
				System.out.println(continent+": "+country.get().getName())
		);
		List<String> continents = 
		  countryDao.findAllCountries()
		         .stream()
		         .map(Country::getContinent)
		         .distinct()
		         .sorted()
		         .collect(Collectors.toList());
	    System.out.println(continents);	
	}

}