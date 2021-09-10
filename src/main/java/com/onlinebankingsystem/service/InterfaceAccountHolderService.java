package com.onlinebankingsystem.service;

import com.onlinebankingsystem.account.Account;
import com.onlinebankingsystem.account.BankStatement;
import com.onlinebankingsystem.users.AccountHolder;

public interface InterfaceAccountHolderService {

	BankStatement getMiniStatement(Account account);
	
}
