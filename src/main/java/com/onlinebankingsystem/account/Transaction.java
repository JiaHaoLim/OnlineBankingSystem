package com.onlinebankingsystem.account;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Entity(name = "transaction")
public class Transaction {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(nullable = false, unique = true)
	private int id;
	
	public static final String DESCRIPTION_COLUMN = "description";
	@Column(name = DESCRIPTION_COLUMN, nullable = false)
	private String description;

	public static final String TYPE_COLUMN = "type";
	@Column(name = TYPE_COLUMN, nullable = false)
	private String type;
	
	public static final String DATE_COLUMN = "date_created";
	@Column(name = DATE_COLUMN, nullable = false)
	@Temporal(value = TemporalType.TIMESTAMP)
	private Date dateCreated;

	public static final String AMOUNT_COLUMN = "amount";
	@Column(name = AMOUNT_COLUMN, nullable = false)
	private double amount;

	public static final String ACCOUNT_ID_COLUMN = "accountID";
	@Column(name = ACCOUNT_ID_COLUMN, nullable = false)
	private int accountID;
	
	public Transaction() {}
	
	public Transaction(String description, String type, Date dateCreated, double amount, int accountID) {
		this.description = description;
		this.type = type;
		this.dateCreated = dateCreated;
		this.amount = amount;
		this.accountID = accountID;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public Date getDateCreated() {
		return dateCreated;
	}

	public void setDateCreated(Date dateCreated) {
		this.dateCreated = dateCreated;
	}

	public double getAmount() {
		return amount;
	}

	public void setAmount(double amount) {
		this.amount = amount;
	}

	public int getAccountID() {
		return accountID;
	}

	public void setAccountID(int accountID) {
		this.accountID = accountID;
	}
}
