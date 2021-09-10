package com.onlinebankingsystem.dao;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.onlinebankingsystem.account.Transaction;

@Repository(value = "TransactionJpaRepository")
public interface TransactionJpaRepository extends InterfaceTransactionDao, JpaRepository<Transaction, Integer> {
	List<Transaction> findFirst10ByAccountIDOrderByDateCreated(int accountID);
}
