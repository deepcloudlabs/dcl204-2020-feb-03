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
		return null;
	}
	public Optional<Customer> removeCustomer(
            String identityNo){
         return Optional.empty();
    }
	public Optional<Customer> getCustomer(
			                     String identityNo){
		return Optional.empty();
	}
	
	public double getBalance() {
		return 0;
	}
}
