package com.onlinebankingsystem.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import com.onlinebankingsystem.account.Account;
import com.onlinebankingsystem.account.BankStatement;
import com.onlinebankingsystem.dao.AccountJpaRepository;
import com.onlinebankingsystem.dao.TransactionJpaRepository;
import com.onlinebankingsystem.service.interfaces.InterfaceAccountService;
import com.onlinebankingsystem.users.AccountHolder;


//@Service a specialization of @Component annotation. 
//Spring Service annotation can be applied only to classes. 
//It is used to mark the class as a service
@Service
public class AccountService implements InterfaceAccountService {

	@Autowired
	@Qualifier(value = "AccountJpaRepository")
	private AccountJpaRepository accountDao;
	
	@Autowired
	@Qualifier(value = "TransactionJpaRepository")
	private TransactionJpaRepository transactionDao;

	@Override
	public void saveAccount(Account account) {
		System.out.println("AccService saveAccount()");
		accountDao.save(account);
		
	}

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

	@Override
	public void requestChequeBook(int accountId) {
	}
}
