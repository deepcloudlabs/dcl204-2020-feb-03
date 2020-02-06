package com.example;

import java.util.HashSet;
import java.util.Set;

/**
 * 
 * @author Binnur Kurt <binnur.kurt@gmail.com>
 *
 */
public class StudyEqualsAndHashCode {

	public static void main(String[] args) {
		Set<Account> accounts = new HashSet<>();
		accounts.add(new Account("TR1",1_000));
		accounts.add(new Account("TR2",2_000));
		accounts.add(new Account("TR3",3_000));
		System.out.println(
			accounts.contains(new Account("TR2",2_000))
		);
	}

}
