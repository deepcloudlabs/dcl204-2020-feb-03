package com.example.banking.app;

import java.util.concurrent.ThreadLocalRandom;

import com.example.banking.entity.Account;
import com.example.banking.entity.CheckingAccount;
import com.example.banking.exception.InsufficientBalanceException;

/**
 * 
 * @author Binnur Kurt <binnur.kurt@gmail.com>
 *
 */
@SuppressWarnings("unused")
public class StudyPolymorphism {

	public static void main(String[] args) throws InsufficientBalanceException {
		Object o;
		o = 42;
		o = true;
		o = new int[] { 1, 2, 3, 4, 5, 6 };
		o = "Jack";
		o = new Account("TR2", 1_000);
		Account acc;
		boolean isTrue = ThreadLocalRandom.current().nextBoolean();
		if (isTrue)
			acc = new Account("TR1", 1_000);
		else
			acc = new CheckingAccount("TR1", 1_000, 500);
		System.out.println(acc.getClass().getName());
		try {
			acc.withdraw(1501);
		} catch (InsufficientBalanceException e) {
			System.out.println(e.getMessage());
			throw e;
		}
	}

}
