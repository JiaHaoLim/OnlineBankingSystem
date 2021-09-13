package com.onlinebankingsystem.dao.interfaces;

import java.util.Optional;

import com.onlinebankingsystem.account.Account;

public interface InterfaceFundTransferDao {

	Optional<Account> findByAccountNumber(String a);
	//FundTransferJpaRepository will take care of Dao functions.

	void save(Account accountB);
}
