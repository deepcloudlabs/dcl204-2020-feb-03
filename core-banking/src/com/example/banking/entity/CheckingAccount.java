package com.example.banking.entity;

import com.example.banking.exception.InsufficientBalanceException;

/**
 * 
 * @author Binnur Kurt <binnur.kurt@gmail.com>
 *
 */
public class CheckingAccount extends Account {
	private double overdraftAmount;

	public CheckingAccount(String iban, double balance) {
		super(iban, balance);
		this.overdraftAmount = 500;
	}

	public CheckingAccount(String iban, double balance, double overdraftAmount) {
		super(iban, balance);
		this.overdraftAmount = overdraftAmount;
	}

	public double getOverdraftAmount() {
		return overdraftAmount;
	}

	public void setOverdraftAmount(double overdraftAmount) {
		this.overdraftAmount = overdraftAmount;
	}

	@Override 
	public void withdraw(double amount) throws InsufficientBalanceException {
		if (amount <= 0.)
			throw new IllegalArgumentException("Amount cannot be negative!");
		if (amount > (balance + overdraftAmount))
			throw new InsufficientBalanceException("Your balance does not cover your expenses!",amount-balance-overdraftAmount);
		this.balance -= amount;
	}

	@Override
	public String toString() {
		return "CheckingAccount [overdraftAmount=" + overdraftAmount + ", balance=" + balance + ", iban="
				+ getIban() + "]";
	}

}
