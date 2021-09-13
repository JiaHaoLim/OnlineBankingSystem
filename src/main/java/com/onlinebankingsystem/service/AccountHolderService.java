package com.onlinebankingsystem.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import com.onlinebankingsystem.account.Account;
import com.onlinebankingsystem.account.BankStatement;
import com.onlinebankingsystem.dao.AccountHolderJpaRepository;
import com.onlinebankingsystem.dao.TransactionJpaRepository;
import com.onlinebankingsystem.users.AccountHolder;

@Service
public class AccountHolderService implements InterfaceAccountHolderService {
	
	@Autowired
	@Qualifier(value = "AccountHolderJpaRepository")
	private AccountHolderJpaRepository ahDao;
	
	@Autowired
	@Qualifier(value = "TransactionJpaRepository")
	private TransactionJpaRepository tDao;

	@Override
	public BankStatement getMiniStatement(int id) {
		AccountHolder accountHolder = ahDao.getById(id);
		return new BankStatement(accountHolder.getName(), accountHolder.getAddress(), 
								tDao.findFirst10ByAccountIdOrderByDateCreated(id));
	}

	@Override
	public BankStatement getDetailedStatement(int id) {
		AccountHolder accountHolder = ahDao.getById(id);
		return new BankStatement(accountHolder.getName(), accountHolder.getAddress(), 
								tDao.findByAccountIdOrderByDateCreated(id));
	}
}
