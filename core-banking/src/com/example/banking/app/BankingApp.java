package com.example.banking.app;

import com.example.banking.entity.Account;

public class BankingApp {
	public static void main(String[] args) {
		Account acc = 
				new Account("TR1", 1_000_000);
		acc.withdraw(50_000);
		System.out.println(acc.getBalance());
		acc.withdraw(1_000_000);
		System.out.println(acc.getBalance());
		System.out.println(acc.toString());
	}
}



