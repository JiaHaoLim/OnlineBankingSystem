package com.onlinebankingsystem.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;

import com.onlinebankingsystem.account.Account;
import com.onlinebankingsystem.account.BankStatement;
import com.onlinebankingsystem.dao.AccountHolderJpaRepository;
import com.onlinebankingsystem.dao.TransactionJpaRepository;
import com.onlinebankingsystem.users.AccountHolder;

public class AccountHolderService implements InterfaceAccountHolderService {
	
	@Autowired
	@Qualifier(value = "AccountHolderJpaRepository")
	private AccountHolderJpaRepository ahDao;
	
	@Autowired
	@Qualifier(value = "TransactionJpaRepository")
	private TransactionJpaRepository tDao;

	@Override
	public BankStatement getMiniStatement(Account account) {
		AccountHolder accountHolder = getAccountHolder(account);
		return new BankStatement(accountHolder.getName(), accountHolder.getAddress(), 
								tDao.findFirst10ByAccountIDOrderByDateCreated(account.getId()));
	}

	@Override
	public BankStatement getDetailedStatement(Account account) {
		AccountHolder accountHolder = getAccountHolder(account);
		return new BankStatement(accountHolder.getName(), accountHolder.getAddress(), 
								tDao.findByAccountIDOrderByDateCreated(account.getId()));
	}

	private AccountHolder getAccountHolder(Account account) {
		return ahDao.getById(account.getAccountHolder().getId());
	}
}
