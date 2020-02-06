package com.example.banking.app;

import com.example.banking.entity.Account;
import com.example.banking.entity.CheckingAccount;
import com.example.banking.exception.InsufficientBalanceException;

/**
 * 
 * @author Binnur Kurt <binnur.kurt@gmail.com>
 *
 */
public class AnotherBankApp {

	public static void main(String[] args) throws InsufficientBalanceException {
		Account acc = new CheckingAccount("TR1", 1_000, 500);
		acc.withdraw(1200);

	}

}
