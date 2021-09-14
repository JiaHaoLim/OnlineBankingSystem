package com.onlinebankingsystem.dao.interfaces;

import java.util.List;

import com.onlinebankingsystem.account.Transaction;

public interface InterfaceTransactionDao {

	List<Transaction> findFirst10ByAccountIdOrderByDateCreated(int accountId);

	List<Transaction> findByAccountIdOrderByDateCreated(int accountId);
	
}
