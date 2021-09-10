package com.onlinebankingsystem.account;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

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
	
	public static final String DATE_COLUMN = "date";
	@Column(name = DATE_COLUMN, nullable = false)
	private Date date;

	public static final String AMOUNT_COLUMN = "amount";
	@Column(name = AMOUNT_COLUMN, nullable = false)
	private double amount;
	
	public Transaction() {}
	
	public Transaction(String description, String type, Date date, double amount) {
		this.description = description;
		this.type = type;
		this.date = date;
		this.amount = amount;
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

	public Date getDate() {
		return date;
	}

	public void setDate(Date date) {
		this.date = date;
	}

	public double getAmount() {
		return amount;
	}

	public void setAmount(double amount) {
		this.amount = amount;
	}
	
	
}
