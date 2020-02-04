package com.example.banking.app;

import java.util.List;
import java.util.Optional;
import java.util.function.Consumer;

import com.example.banking.entity.Account;
import com.example.banking.entity.Customer;

/**
 * 
 * @author Binnur Kurt <binnur.kurt@gmail.com>
 *
 */
public class BankingApp {
	public static void main(String[] args) {
		Account acc = new Account("TR1", 1_000_000);
		acc.withdraw(50_000);
		System.out.println(acc.getBalance());
		acc.withdraw(1_000_000);
		System.out.println(acc.getBalance());
		System.out.println(acc.toString());

		Customer jack = new Customer("1", "Jack Shephard");
		jack.addAccount(new Account("TR2", 2_000));
		jack.addAccount(new Account("TR3", 3_000));
		jack.addAccount(new Account("TR4", 4_000));
		List<Account> accts = jack.getAccounts();
//		accts.add(new Account("TR5",5_000));
		for (Account account : accts)
			System.out.println(account);

		Consumer<Account> withdraw500 = 
				 a -> a.withdraw(500);
		Optional<Account> account = 
				jack.getAccount("TR6");
		account.ifPresent( withdraw500 );
		if(account.isPresent())
			account.get().withdraw(500);
		System.out.println(jack.getBalance8());
	}
}






