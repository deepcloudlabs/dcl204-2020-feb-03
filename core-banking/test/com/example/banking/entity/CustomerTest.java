package com.example.banking.entity;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

/**
 * 
 * @author Binnur Kurt <binnur.kurt@gmail.com>
 *
 */
class CustomerTest {

	@Test
	void createCustomer() {
		Customer jack = new Customer("1", "Jack Bauer");
		assertEquals("1", jack.getIdentityNo());
		assertEquals("Jack Bauer", jack.getFullName());
		assertEquals(0, jack.getAccounts().size());
	}

	@Test
	void manageAccounts() {
		Customer jack = new Customer("1", "Jack Bauer");
		assertEquals(0, jack.getAccounts().size());
		jack.addAccount(new Account("TR1", 1_000));
		jack.addAccount(new CheckingAccount("TR2", 2_000));
		jack.addAccount(new Account("TR3", 3_000));
		assertEquals(3, jack.getAccounts().size());
		assertEquals("TR1", jack.getAccount(0).getIban());
		assertEquals("TR2", jack.getAccount(1).getIban());
		assertEquals("TR3", jack.getAccount(2).getIban());
		assertFalse(jack.removeAccount("TR4").isPresent());
		assertEquals(3, jack.getAccounts().size());
		assertEquals(6_000, jack.getBalance());
		assertTrue(jack.removeAccount("TR1").isPresent());
		assertEquals(2, jack.getAccounts().size());
		assertEquals(5_000, jack.getBalance8());
		assertTrue(jack.removeAccount("TR2").isPresent());
		assertEquals(1, jack.getAccounts().size());
		assertEquals(3_000, jack.getBalance_8());
		assertTrue(jack.removeAccount("TR3").isPresent());
		assertEquals(0, jack.getAccounts().size());
		assertEquals(0, jack.getBalance());
	}
	
}
