package com.onlinebankingsystem.users;

import java.util.Date;

import javax.persistence.Entity;

import com.onlinebankingsystem.users.User.Role;

@Entity(name = "bank_admin")
public class BankAdmin extends User {

	public BankAdmin() {
		super();
		this.role = Role.BANK_ADMIN;
	}

	public BankAdmin(String name, String username, String password, String secretQuestion,
			String secretAnswer) {
		super(name, username, password, secretQuestion, secretAnswer);
		this.role = Role.BANK_ADMIN;
	}
	
	public BankAdmin(String name, String username, String password, String secretQuestion,
			String secretAnswer, int numFailedLogins, boolean isLocked, Date dateCreated) {
		super(name, username, password, secretQuestion, secretAnswer, numFailedLogins, isLocked, dateCreated);
		this.role = Role.BANK_ADMIN;
	}
}
