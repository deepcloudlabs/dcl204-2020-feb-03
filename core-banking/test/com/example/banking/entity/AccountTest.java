package com.example.banking.entity;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class AccountTest {

	@Test
	void toStringContainsIbanAndBalance() {
		Account acc = new Account("TR1", 1_000);
		String str = acc.toString();
		assertTrue(str.contains("iban="));
		assertTrue(str.contains("balance="));
	}

	@Test
	void withdrawWithNegativeAmount() {
		Account acc = new Account("TR1", 1_000);
		assertFalse(acc.withdraw(-1.0));
		assertEquals(1_000, acc.getBalance());
		assertEquals("TR1", acc.getIban());
	}

	@Test
	void withdrawOverBalance() {
		Account acc = new Account("TR1", 1_000);
		assertFalse(acc.withdraw(1_001));
		assertEquals(1_000, acc.getBalance());
		assertEquals("TR1", acc.getIban());
	}

	@Test
	void withdrawAllBalance() {
		Account acc = new Account("TR1", 1_000);
		assertTrue(acc.withdraw(1_000));
		assertEquals(0, acc.getBalance());
		assertEquals("TR1", acc.getIban());
	}

	@Test
	void depositWithNegativeAmount() {
		Account acc = new Account("TR1", 1_000);
		assertFalse(acc.deposit(-1.0));
		assertEquals(1_000, acc.getBalance());
		assertEquals("TR1", acc.getIban());
	}

	@Test
	void depositWithPositiveAmount() {
		Account acc = new Account("TR1", 1_000);
		assertTrue(acc.deposit(1.0));
		assertEquals(1_001, acc.getBalance());
		assertEquals("TR1", acc.getIban());
	}

}
