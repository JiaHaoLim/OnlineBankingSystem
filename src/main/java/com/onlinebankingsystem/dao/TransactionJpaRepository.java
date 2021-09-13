package com.onlinebankingsystem.dao;

import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.onlinebankingsystem.account.Transaction;
import com.onlinebankingsystem.config.AppConfig;
import com.onlinebankingsystem.dao.interfaces.InterfaceTransactionDao;

@Repository(value = AppConfig.TRANSACTION_JPA)
public interface TransactionJpaRepository extends InterfaceTransactionDao, JpaRepository<Transaction, Integer> {
	List<Transaction> findFirst10ByAccountIdOrderByDateCreated(int accountId);
	
	List<Transaction> findByAccountIdOrderByDateCreated(int accountId);
}
