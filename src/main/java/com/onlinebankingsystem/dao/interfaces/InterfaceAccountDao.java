package com.onlinebankingsystem.dao.interfaces;

import com.onlinebankingsystem.account.Account;

public interface InterfaceAccountDao {

	void save(Account account);

	Account getById(int accountId);

	

}
                 