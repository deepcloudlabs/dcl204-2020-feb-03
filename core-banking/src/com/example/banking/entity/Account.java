package com.example.banking.entity;

/**
 * 
 * @author Binnur Kurt <binnur.kurt@gmail.com>
 *
 */
public class Account extends Object {
	private final String iban;
	double balance;

	public Account(String iban, double balance) {
		this.iban = iban;
		this.balance = balance;
	}

	public final String getIban() {
		return iban;
	}

	public final double getBalance() {
		return balance;
	}

	public boolean deposit(double amount) {
		// validation
		if (amount <= 0)
			return false;
		this.balance = this.balance + amount;
		return true;
	}

	public boolean withdraw(double amount) {
		System.out.println("Account::withdraw");
		// validation
		if (amount <= 0)
			return false;
		// business rule
		if (amount > balance)
			return false;
		this.balance = this.balance - amount;
		return true;
	}

	@Override
	public String toString() {
		return "Account [iban=" + iban + ", balance=" + balance + "]";
	}

}
