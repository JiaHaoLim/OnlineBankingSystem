package com.onlinebankingsystem.account;

import java.util.Random;

import javax.persistence.Column;
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

	
	
	public static final String ACC_ACCOUNT_TYPE_COLUMN = "acc_account_type";
	@Column(name = ACC_ACCOUNT_TYPE_COLUMN) 
	private String account_type;
	
	public static final String ACC_BALANCE_COLUMN = "acc_balance";
	@Column(name = ACC_BALANCE_COLUMN) 
	private double acc_balance;
	
	public static final String ACC_ACCOUNT_NUMBER_COLUMN = "acc_account_number";
	@Column(name = ACC_ACCOUNT_NUMBER_COLUMN)
	private String accountNumber;
	
	public Account()
	{
		accountNumber = accNumberGenerator();
	}
	
	public double withdaw(double amountXfer)
	{
		if(this.acc_balance < amountXfer )
		{
			return this.acc_balance; 
		}
		
		double newAbalance = this.acc_balance - amountXfer;
		return newAbalance;
	}
	
	public double deposit(double amountDeposit)
	{
		if(amountDeposit < 0.0)
		{
			return this.acc_balance;
		}
		double newBbalance = this.acc_balance + amountDeposit;
		return newBbalance;
	}
	public String accNumberGenerator()
	{
//		 int min = (int) Math.pow(10, length - 1);
//	     int max = (int) Math.pow(10, length); // bound is exclusive
//	     Random random = new Random();
//	     return (random.nextInt(max - min) + min);	
		
		Random rand = new Random();
	    String branchNum = "138";
	    int branch = 0;
	    for (int i = 0; i < 7; i++) // adding next 6 numbers behind
	    {
	        int n = rand.nextInt(9) + 0;
	        branchNum += Integer.toString(n);
	        
	    }
	    return branchNum;
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

	public AccountHolder getAccountHolder() {
		return accountHolder;
	}

	public void setAccountHolder(AccountHolder accountHolder) {
		this.accountHolder = accountHolder;
	}
	public String getAccount_type() {
		return account_type;
	}
	public void setAccount_type(String account_type) {
		this.account_type = account_type;
	}
	public double getAcc_balance() {
		return acc_balance;
	}
	public void setAcc_balance(double acc_balance) {
		this.acc_balance = acc_balance;
	}
	public String getAccountNumber() {
		return accountNumber;
	}
	public void setAccountNumber(String accountNumber) {
		this.accountNumber = accountNumber;
	}
	@Override
	public String toString() {
		return "Account [id=" + id + ", accountHolder=" + accountHolder + ", account_type=" + account_type
				+ ", acc_balance=" + acc_balance + ", accountNumber=" + accountNumber + "]";
	}
	
	
}
