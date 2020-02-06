package com.example.banking.entity;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

import com.example.banking.exception.InsufficientBalanceException;

/**
 * 
 * @author Binnur Kurt <binnur.kurt@gmail.com>
 *
 */
class CheckingAccountTest {

	@Test
	void withdrawWithNegativeAmount() {
		CheckingAccount acc = new CheckingAccount("TR1", 1_000);
		acc.setOverdraftAmount(500);
		assertThrows(IllegalArgumentException.class, () -> acc.withdraw(-1.0));
		assertEquals(1_000, acc.getBalance());
		assertEquals(500, acc.getOverdraftAmount());
	}

	@Test
	void withdrawOverBalanceAndOverdraft() {
		CheckingAccount acc = new CheckingAccount("TR1", 1_000, 500);
		assertThrows(InsufficientBalanceException.class, () -> acc.withdraw(1_501.0));
		assertEquals(1_000, acc.getBalance());
		assertEquals(500, acc.getOverdraftAmount());
	}

	@Test
	void withdrawAllAllowed() throws Exception {
		CheckingAccount acc = new CheckingAccount("TR1", 1_000, 500);
		acc.withdraw(1_500);
		assertEquals(-500, acc.getBalance());
		assertEquals(500, acc.getOverdraftAmount());
	}

	@Test
	void toStringContainsIbanAndBalance() {
		CheckingAccount acc = new CheckingAccount("TR1", 1_000);
		String str = acc.toString();
		assertAll(() -> assertTrue(str.contains("iban=")), () -> assertTrue(str.contains("balance=")),
				() -> assertTrue(str.contains("overdraftAmount=")));
	}

}
