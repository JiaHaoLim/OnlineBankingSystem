package com.onlinebankingsystem.account;

import java.util.Random;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.onlinebankingsystem.users.AccountHolder;

@Entity(name = "account")
public class Account {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int id;

	@ManyToOne
	@JsonBackReference
	private AccountHolder accountHolder;

	public static final String TYPE_COLUMN = "type";
	@Column(name = TYPE_COLUMN)
	private String type;

	public static final String BALANCE_COLUMN = "balance";
	@Column(name = BALANCE_COLUMN)
	private double balance;

	public static final String ACCOUNT_NUMBER_COLUMN = "account_number";
	@Column(name = ACCOUNT_NUMBER_COLUMN)
	private String accountNumber;

	public Account() {
		accountNumber = accountNumberGenerator();
	}

	public double withdaw(double amount) {
		if (this.balance < amount) {
			return this.balance;
		}

		double newAbalance = this.balance - amount;
		return newAbalance;
	}

	public double deposit(double amount) {
		if (amount < 0.0) {
			return this.balance;
		}
		double newBbalance = this.balance + amount;
		return newBbalance;
	}

	public String accountNumberGenerator() {
		Random rand = new Random();
		String branchNum = "138";

		for (int i = 0; i < 7; i++) // adding next 6 numbers behind
		{
			int n = rand.nextInt(9) + 0;
			branchNum += Integer.toString(n);

		}
		return branchNum;
		// for (int i = 0; i < 9; i++)
		// {
		// if(i % 3 == 0) // splitting the string into 3 char each
		// System.out.print(" ");
		// System.out.print(branch.charAt(i));
		// }
	}

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

	public String getType() {
		return type;
	}

	public void setType(String accountType) {
		this.type = accountType;
	}

	public double getBalance() {
		return balance;
	}

	public void setBalance(double balance) {
		this.balance = balance;
	}

	public String getAccountNumber() {
		return accountNumber;
	}

	public void setAccountNumber(String accountNumber) {
		this.accountNumber = accountNumber;
	}
}
