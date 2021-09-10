package com.onlinebankingsystem.newAccount;

import java.util.Random;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "Accounts")
public class Account {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int id;
	
//	public static final String ACC_NAME_COLUMN = "acc_name";
//	@Column(name = ACC_NAME_COLUMN) // giving name to table columns
//	private String name;
//	
//	public static final String ACC_ADDRESS_COLUMN = "acc_address";
//	@Column(name = ACC_ADDRESS_COLUMN) 
//	private String address;
//	
//	public static final String ACC_MOBLIE_COLUMN = "acc_moblie";
//	@Column(name = ACC_MOBLIE_COLUMN) 
//	private int mobile;
//	
//	public static final String ACC_EMAIL_ID_COLUMN = "acc_email_id";
//	@Column(name = ACC_EMAIL_ID_COLUMN) 
//	private String email_id;
	
	public static final String ACC_ACCOUNT_TYPE_COLUMN = "acc_account_type";
	@Column(name = ACC_ACCOUNT_TYPE_COLUMN) 
	private String account_type;
	
	public static final String ACC_OPENING_BALANCE_COLUMN = "acc_opening_balance";
	@Column(name = ACC_OPENING_BALANCE_COLUMN) 
	private String opening_balance;
	
	public static final String ACC_ACCOUNT_NUMBER_COLUMN = "acc_account_number";
	@Column(name = ACC_ACCOUNT_NUMBER_COLUMN)
	private String accountNumber;
	
	public Account()
	{
		accountNumber = accNumberGenerator();
	}
	
	//generating random account numbers 
	public String accNumberGenerator()
	{
//		 int min = (int) Math.pow(10, length - 1);
//	     int max = (int) Math.pow(10, length); // bound is exclusive
//	     Random random = new Random();
//	     return (random.nextInt(max - min) + min);	
		
		Random rand = new Random();
	    String branch = "138";
	    for (int i = 0; i < 7; i++) // adding next 6 numbers behind
	    {
	        int n = rand.nextInt(9) + 0;
	        branch += Integer.toString(n);
	    }
	    return branch;
        // for (int i = 0; i < 9; i++)
        // {
	    //	 if(i % 3 == 0) // splitting the string into 3 char each
       //  System.out.print(" ");
	   //  System.out.print(branch.charAt(i));
	  //  }
	}


	public int getId() {
		return id;
	}


	public void setId(int id) {
		this.id = id;
	}


	public String getAccount_type() {
		return account_type;
	}


	public void setAccount_type(String account_type) {
		this.account_type = account_type;
	}


	public String getOpening_balance() {
		return opening_balance;
	}


	public void setOpening_balance(String opening_balance) {
		this.opening_balance = opening_balance;
	}


	public String getAccountNumber() {
		return accountNumber;
	}


	public void setAccountNumber(String accountNumber) {
	
		this.accountNumber = accountNumber;
	}

	@Override
	public String toString() {
		return "Account [id=" + id + ", account_type=" + account_type + ", opening_balance=" + opening_balance
				+ ", accountNumber=" + accountNumber + "]";
	}


	
}
