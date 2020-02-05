package com.example.banking.app;

import com.example.banking.entity.Account;

/**
 * 
 * @author Binnur Kurt <binnur.kurt@gmail.com>
 *
 */
@SuppressWarnings("static-access")
public class StudyStaticMembers {

	public static void main(String[] args) {
		System.out.println(Account.getNumOfAccounts());
		new Account("TR1", 1_000);
		new Account("TR1", 1_000);
		new Account("TR1", 1_000);
		new Account("TR1", 1_000);
		new Account("TR1", 1_000);
		new Account("TR1", 1_000);
		Account acc = new Account("TR1", 1_000);
		System.out.println(Account.getNumOfAccounts());
		System.out.println(acc.getNumOfAccounts());
	}

}
