package com.example.banking.entity;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

/**
 * 
 * @author Binnur Kurt <binnur.kurt@gmail.com>
 *
 */
class BankTest {

	@Test
	void createBank() {
		Bank garanti = new Bank(1, "Garanti");
		assertEquals(1, garanti.getId());
		assertEquals("Garanti", garanti.getName());
		assertEquals(0, garanti.getCustomers().size());
	}

	@Test
	void manageCustomers() {
		Bank garanti = new Bank(1, "Garanti");
		Customer jack = garanti.createCustomer("1", "Jack Bauer");
		assertEquals("1", jack.getIdentityNo());
		assertEquals("Jack Bauer", jack.getFullName());
		jack.addAccount(new Account("TR1", 1_000));
		jack.addAccount(new CheckingAccount("TR2", 2_000));
		jack.addAccount(new Account("TR3", 3_000));
		assertEquals(1, garanti.getCustomers().size());
		Customer kate = garanti.createCustomer("2", "Kate Austen");
		assertEquals("2", kate.getIdentityNo());
		assertEquals("Kate Austen", kate.getFullName());
		kate.addAccount(new Account("TR11", 10_000));
		kate.addAccount(new CheckingAccount("TR12", 20_000));
		kate.addAccount(new Account("TR13", 30_000));
		assertEquals(2, garanti.getCustomers().size());
		assertNotNull(garanti.getCustomer("1"));
		assertNotNull(garanti.getCustomer("2"));
		assertNull(garanti.getCustomer("3"));
		assertTrue(garanti.getRichestCustomer().isPresent());
		assertEquals("2", garanti.getRichestCustomer().get().getIdentityNo());
	}

}
