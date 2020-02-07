package com.example.banking.entity;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;

/**
 * 
 * @author Binnur Kurt <binnur.kurt@gmail.com>
 *
 */
public class Customer implements Serializable {
	private final String identityNo;
	private String fullName;
	private final Map<String,Account> accounts;

	public Customer(String identityNo, String fullName) {
		this.identityNo = identityNo;
		this.fullName = fullName;
		accounts = new HashMap<>();
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
		return new ArrayList<>(accounts.values());
	}

	public void addAccount(Account account) {
		accounts.put(account.getIban(),account);
	}

	public Optional<Account> getAccount(String iban) {
		return Optional.ofNullable(accounts.get(iban));
	}

	public double getBalance() {
		return accounts.values().stream()
		        .mapToDouble(Account::getBalance)
			    .sum();
	}

	public Optional<Account> removeAccount(String iban) {
		
		return Optional.ofNullable(
				accounts.remove(iban)
		);
	}

	@Override
	public String toString() {
		return "Customer [identityNo=" + identityNo + ", fullName=" + fullName + "]";
	}

}
