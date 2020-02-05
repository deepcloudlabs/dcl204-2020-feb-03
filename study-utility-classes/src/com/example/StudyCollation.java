package com.example;

import java.text.Collator;
import java.text.RuleBasedCollator;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Locale;

/**
 * 
 * @author Binnur Kurt <binnur.kurt@gmail.com>
 *
 */
public class StudyCollation {

	public static void main(String[] args) throws Exception {
		String name1 = "şima";
		String name2 = "shema";
		String name3 = "şule";
		String name4 = "schule";
		System.out.println(name1.equals(name2));
		System.out.println(name3.equals(name4));
		String basicRules=  "< z < b < c < ç < d < e < f < g < ğ < h "+
		        "< ı < i < j < k < l < m < n < o < ö < p "+
		       "< r < s < ş < t < u < ü < v < y < a ";
		String trExpension= "& şi ; she & ş ; sch & s ; ş & u ; ü & i ; ı " + 
		                    "& c ; ç & o ; ö & ğ ; g" ;
		final Collator collator= new RuleBasedCollator(basicRules + trExpension);
		Collator.getInstance(new Locale("tr","TR"));
		collator.setStrength(Collator.PRIMARY);
		System.out.println(collator.equals(name1, name2));
		System.out.println(collator.equals(name3, name4));
		List<String> names = new ArrayList<>();
		names.add("şule");
		names.add("sema");
		names.add("şima");
		names.add("zehra");
		names.add("ayşegül");
		Collections.sort(names,collator::compare);
		System.out.println(names);
	}

}
