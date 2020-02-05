package com.example.banking.entity;

/**
 * 
 * @author Binnur Kurt <binnur.kurt@gmail.com>
 *
 */
public enum AccountStatus {
	ACTIVE(100), CLOSED(200), PASSIVE(300);
	private int code;

	private AccountStatus(int code) {
		this.code = code;
	}

	public int getCode() {
		return code;
	}
	
}
