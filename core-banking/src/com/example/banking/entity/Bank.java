package com.example.banking.entity;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.Optional;

/**
 * 
 * @author Binnur Kurt <binnur.kurt@gmail.com>
 *
 */
public class Bank {
	private final int id;
	private String name;
	private final List<Customer> customers;

	public Bank(int id, String name) {
		this.id = id;
		this.name = name;
		customers = new ArrayList<>();
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getId() {
		return id;
	}

	public List<Customer> getCustomers() {
		return Collections.unmodifiableList(customers);
	}

	public Customer createCustomer(String identityNo, String fullName) {
		Optional<Customer> customer = getCustomer8(identityNo);
		if (customer.isPresent())
			return customer.get();
		Customer cust = new Customer(identityNo, fullName);
		customers.add(cust);
		return cust;
	}

	public Optional<Customer> removeCustomer(String identityNo) {
		Optional<Customer> customer = getCustomer8(identityNo);
		customer.ifPresent(cust -> customers.remove(cust));
		return customer;
	}

	public Customer getCustomer(String identityNo) {
		for (Customer cust : customers)
			if (cust.getIdentityNo().equals(identityNo))
				return cust;
		return null;
	}

	public Optional<Customer> getCustomer8(String identityNo) {
		return customers.stream().filter(customer -> customer.getIdentityNo().equals(identityNo)).findFirst();
	}

	public Optional<Customer> getRichestCustomer() {
		return customers.stream().sorted(Comparator.comparing(Customer::getBalance).reversed()).findFirst();
	}

}
