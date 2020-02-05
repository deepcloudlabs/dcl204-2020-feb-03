package com.example.banking.entity;

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
	public boolean withdraw(double amount) {
		System.out.println("CheckingAccount::withdraw");
		if (amount <= 0.)
			return false;
		if (amount > (balance + overdraftAmount))
			return false;
		this.balance -= amount;
		return true;
	}

	@Override
	public String toString() {
		return "CheckingAccount [overdraftAmount=" + overdraftAmount + ", balance=" + balance + ", iban="
				+ getIban() + "]";
	}

}
