package com.onlinebankingsystem.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import com.onlinebankingsystem.account.Account;
import com.onlinebankingsystem.account.BankStatement;
import com.onlinebankingsystem.dao.AccountHolderJpaRepository;
import com.onlinebankingsystem.dao.AccountJpaRepository;
import com.onlinebankingsystem.dao.TransactionJpaRepository;
import com.onlinebankingsystem.users.AccountHolder;

@Service
public class AccountHolderService implements InterfaceAccountHolderService {
	@Autowired
	@Qualifier(value = "AccountJpaRepository")
	private AccountJpaRepository accountDao;
	
	@Autowired
	@Qualifier(value = "AccountHolderJpaRepository")
	private AccountHolderJpaRepository accountHolderDao;
	
	@Autowired
	@Qualifier(value = "TransactionJpaRepository")
	private TransactionJpaRepository transactionDao;

	@Override
	public BankStatement getMiniStatement(int accountId) {
		AccountHolder accountHolder = accountDao.getById(accountId).getAccountHolder();
		return new BankStatement(accountHolder.getName(), accountHolder.getAddress(), 
								transactionDao.findFirst10ByAccountIdOrderByDateCreated(accountId));
	}

	@Override
	public BankStatement getDetailedStatement(int accountId) {
		AccountHolder accountHolder = accountDao.getById(accountId).getAccountHolder();
		return new BankStatement(accountHolder.getName(), accountHolder.getAddress(), 
								transactionDao.findByAccountIdOrderByDateCreated(accountId));
	}
}
