package com.onlinebankingsystem.users;

import java.util.Date;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;

import com.onlinebankingsystem.account.Account;

@Entity(name = "account_holder")
public class AccountHolder extends User {
	
	public static final String ADDRESS_COLUMN = "address";
	@Column(name = ADDRESS_COLUMN, nullable = false)
	private String address;
	
	public static final String MOBILE_NUMBER_COLUMN = "mobile_number";
	@Column(name = MOBILE_NUMBER_COLUMN, nullable = false)
	private String mobileNumber;
	
	public static final String EMAIL_COLUMN = "email";
	@Column(name = EMAIL_COLUMN, nullable = false)
	private String email;
	
	@OneToMany(targetEntity = Account.class, cascade = CascadeType.ALL)
	@JoinColumn(name = "account_holder_id")
	private List<Account> accounts;
	
	public AccountHolder() {}
	
	public AccountHolder(String name, String username, String password, String secretQuestion,
			String secretAnswer, String address, String mobileNumber, String email) {
		super(name, username, password, secretQuestion, secretAnswer);
		setDetails(address, mobileNumber, email);
	}
	
	public AccountHolder(String name, String username, String password, String secretQuestion,
			String secretAnswer, int numFailedLogins, boolean isLocked, Date dateCreated, 
			String address, String mobileNumber, String email) {
		super(name, username, password, secretQuestion, secretAnswer, numFailedLogins, isLocked, dateCreated);
		setDetails(address, mobileNumber, email);
	}
	
	private void setDetails(String address, String mobileNumber, String email) {
		this.address = address;
		this.mobileNumber = mobileNumber;
		this.email = email;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getMobileNumber() {
		return mobileNumber;
	}

	public void setMobileNumber(String mobileNumber) {
		this.mobileNumber = mobileNumber;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public List<Account> getAccounts() {
		return accounts;
	}

	public void setAccounts(List<Account> accounts) {
		this.accounts = accounts;
	}
	
	public void addAccount(Account account) {
		accounts.add(account);
	}
	
	public void removeAccount(Account account) {
		accounts.remove(account);
	}
}
