package com.onlinebankingsystem.users;

import javax.persistence.Entity;

@Entity(name = "bank_admin")
public class BankAdmin extends User {

	public BankAdmin() {
		super();
	}

	public BankAdmin(String name, String loginUsername, String loginPassword, String secretQuestion,
			String secretAnswer, int numFailedLogins, boolean isLocked) {
		super(name, loginUsername, loginPassword, secretQuestion, secretAnswer, numFailedLogins, isLocked);
	}

	public BankAdmin(String name, String loginUsername, String loginPassword, String secretQuestion,
			String secretAnswer) {
		super(name, loginUsername, loginPassword, secretQuestion, secretAnswer);
	}
	
}
