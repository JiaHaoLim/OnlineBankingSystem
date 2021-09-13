package com.onlinebankingsystem.account;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

import com.onlinebankingsystem.users.AccountHolder;

@Entity(name = "account")
public class Account {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int id;
	
	@ManyToOne
	private AccountHolder accountHolder;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public AccountHolder getAccountHolder() {
		return accountHolder;
	}

	public void setAccountHolder(AccountHolder accountHolder) {
		this.accountHolder = accountHolder;
	}
}
