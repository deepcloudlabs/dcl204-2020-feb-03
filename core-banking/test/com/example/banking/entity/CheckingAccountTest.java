package com.example.banking.entity;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

/**
 * 
 * @author Binnur Kurt <binnur.kurt@gmail.com>
 *
 */
class CheckingAccountTest {

	@Test
	void withdrawWithNegativeAmount() {
		CheckingAccount acc = new CheckingAccount("TR1", 1_000, 500);
		assertFalse(acc.withdraw(-1.0));
		assertEquals(1_000, acc.getBalance());
		assertEquals(500, acc.getOverdraftAmount());
	}

	@Test
	void withdrawOverBalanceAndOverdraft() {
		CheckingAccount acc = new CheckingAccount("TR1", 1_000, 500);
		assertFalse(acc.withdraw(1_501));
		assertEquals(1_000, acc.getBalance());
		assertEquals(500, acc.getOverdraftAmount());
	}

	@Test
	void withdrawAllAllowed() {
		CheckingAccount acc = new CheckingAccount("TR1", 1_000, 500);
		assertTrue(acc.withdraw(1_500));
		assertEquals(-500, acc.getBalance());
		assertEquals(500, acc.getOverdraftAmount());
	}

}
