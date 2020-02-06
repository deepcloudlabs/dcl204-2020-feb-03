package com.example;

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

	public final boolean deposit(final double amount) {
		// validation
		if (amount <= 0)
			return false;
		this.balance = this.balance + amount;
		return true;
	}

	public boolean withdraw(final double amount) {
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
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((iban == null) ? 0 : iban.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Account other = (Account) obj;
		if (iban == null) {
			if (other.iban != null)
				return false;
		} else if (!iban.equals(other.iban))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "Account [iban=" + iban + ", balance=" + balance + "]";
	}

}
