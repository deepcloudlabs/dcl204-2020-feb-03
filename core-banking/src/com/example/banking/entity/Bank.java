package com.example.banking.entity;

import java.util.ArrayList;
import java.util.Collections;
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

	public Customer createCustomer(
			String identityNo,String fullName) {
		Optional<Customer> customer = 
				getCustomer(identityNo);
		if(customer.isPresent()) return null;
		Customer cust = new Customer(identityNo, fullName);
		customers.add(cust);
		return cust;
	}
	public Optional<Customer> removeCustomer(
            String identityNo){
		 Optional<Customer> customer = 
				getCustomer(identityNo);
		 customer.ifPresent(
				 cust -> customers.remove(cust));
         return customer;
    }
	public Optional<Customer> getCustomer(
			                     String identityNo){
		return customers.stream()
				.filter(cust -> cust.getIdentityNo()
						       .equals(identityNo))
				.findFirst();
	}
	
	public double getBalance() {
		return customers.stream()
				  .mapToDouble(Customer::getBalance)
				  .sum();
	}
}
