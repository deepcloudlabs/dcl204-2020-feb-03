package com.example.banking.entity;

import com.example.banking.exception.InsufficientBalanceException;

/**
 * 
 * @author Binnur Kurt <binnur.kurt@gmail.com>
 *
 */
public class Account extends Object {
	private final String iban;
	double balance;
	private static int numOfAccounts = 0;
	private AccountStatus status;

	public static int getNumOfAccounts() {
		return numOfAccounts;
	}

	public AccountStatus getStatus() {
		return status;
	}

	public void setStatus(AccountStatus status) {
		this.status = status;
	}

	public Account(String iban, double balance) {
		this.iban = iban;
		this.balance = balance;
		numOfAccounts++;
	}

	public final String getIban() {
		return iban;
	}

	public final double getBalance() {
		return balance;
	}

	public final void deposit(final double amount) {
		// validation
		if (amount <= 0)
			throw new IllegalArgumentException("Amount cannot be negative!");
		this.balance = this.balance + amount;
	}

	public void withdraw(final double amount) throws InsufficientBalanceException {
		// validation
		if (amount <= 0)
			throw new IllegalArgumentException("Amount cannot be negative!");
		// business rule
		if (amount > balance)
			throw new InsufficientBalanceException("Your balance does not cover your expenses!",amount-balance);
		this.balance = this.balance - amount;
	}

	@Override
	public String toString() {
		return "Account [iban=" + iban + ", balance=" + balance + "]";
	}

}
