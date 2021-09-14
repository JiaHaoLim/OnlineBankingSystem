package com.onlinebankingsystem.service.interfaces;

import com.onlinebankingsystem.account.Account;
import com.onlinebankingsystem.account.BankStatement;

public interface InterfaceAccountService {

	public void saveAccount( Account account);

	BankStatement getMiniStatement(int id);

	BankStatement getDetailedStatement(int id);

	public void requestChequeBook(int accountId);
	
}
