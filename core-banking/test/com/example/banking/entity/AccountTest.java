package com.example.banking.entity;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

import com.example.banking.exception.InsufficientBalanceException;

/**
 * 
 * @author Binnur Kurt <binnur.kurt@gmail.com>
 *
 */
class AccountTest {

	@Test
	void toStringContainsIbanAndBalance() {
		Account acc = new Account("TR1", 1_000);
		String str = acc.toString();
		assertAll(
		   () -> assertTrue(str.contains("iban=")),
		   () -> assertTrue(str.contains("balance="))
		);
	}

	@Test
	void withdrawWithNegativeAmount() {
		Account acc = new Account("TR1", 1_000);
		assertThrows(IllegalArgumentException.class,
			() -> acc.withdraw(-1.0));
		assertEquals(1_000, acc.getBalance());
		assertEquals("TR1", acc.getIban());
	}

	@Test
	void withdrawOverBalance() {
		Account acc = new Account("TR1", 1_000);
		assertThrows(InsufficientBalanceException.class,
				() -> acc.withdraw(1_001));
		assertEquals(1_000, acc.getBalance());
		assertEquals("TR1", acc.getIban());
	}

	@Test
	void withdrawAllBalance() throws Exception {
		Account acc = new Account("TR1", 1_000);
		acc.withdraw(1_000);
		assertEquals(0, acc.getBalance());
		assertEquals("TR1", acc.getIban());
	}

	@Test
	void depositWithNegativeAmount() {
		Account acc = new Account("TR1", 1_000);
		assertThrows(IllegalArgumentException.class,
				() -> acc.deposit(-1.0));	
		assertEquals(1_000, acc.getBalance());
		assertEquals("TR1", acc.getIban());
	}

	@Test
	void depositWithPositiveAmount() throws Exception {
		Account acc = new Account("TR1", 1_000);
		acc.deposit(1.0);
		assertEquals(1_001, acc.getBalance());
		assertEquals("TR1", acc.getIban());
	}

}
