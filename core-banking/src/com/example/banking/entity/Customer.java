package com.example.banking.entity;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Optional;
import java.util.stream.Stream;

/**
 * 
 * @author Binnur Kurt <binnur.kurt@gmail.com>
 *
 */
public class Customer {
	private final String identityNo;
	private String fullName;
	private final List<Account> accounts;

	public Customer(String identityNo, String fullName) {
		this.identityNo = identityNo;
		this.fullName = fullName;
		accounts = new ArrayList<>();
	}

	public String getFullName() {
		return fullName;
	}

	public void setFullName(String fullName) {
		this.fullName = fullName;
	}

	public String getIdentityNo() {
		return identityNo;
	}

	public List<Account> getAccounts() {
		return Collections.unmodifiableList(accounts);
	}

	public void addAccount(Account account) {
		accounts.add(account);
	}

	public Optional<Account> getAccount(String iban) {
		for (Account acc : accounts)
			if (acc.getIban().equals(iban))
				return Optional.of(acc);
		return Optional.empty();
	}

	public double getBalance() {
		double sum = 0.0;
		for (Account acc : accounts)
			sum += acc.getBalance();
		return sum;
	}

	public double getBalance8() {
//		final int x[]= {0};
		return accounts.stream().parallel()
//				.map(a -> {x[0]++; return a;})
				.mapToDouble(Account::getBalance).sum();
	}

	public double getBalance_8() {
		Stream<Account> stream = accounts.stream();
		if (accounts.size() > 1_000_000)
			stream = stream.parallel();
		return stream.mapToDouble(Account::getBalance).sum();
	}

	public Account getAccount(int index) {
		return accounts.get(index);
	}

	public Optional<Account> removeAccount(String iban) {
		Optional<Account> acc = getAccount(iban);
		if (acc.isPresent()) {
			this.accounts.remove(acc.get());
		}
		return acc;
	}

}
