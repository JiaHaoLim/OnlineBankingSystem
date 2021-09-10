package com.onlinebankingsystem.account;

import java.util.List;

public class BankStatement {
	private String name;
	private String address;
	
	private List<Transaction> transactions;
	
	public BankStatement() {}

	public BankStatement(String name, String address, List<Transaction> transactions) {
		this.name = name;
		this.address = address;
		this.transactions = transactions;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public List<Transaction> getTransactions() {
		return transactions;
	}

	public void setTransactions(List<Transaction> transactions) {
		this.transactions = transactions;
	}
	
	public void addTransaction(Transaction transaction) {
		transactions.add(transaction);
	}
	
	public void removeTransaction(Transaction transaction) {
		transactions.remove(transaction);
	}
}
