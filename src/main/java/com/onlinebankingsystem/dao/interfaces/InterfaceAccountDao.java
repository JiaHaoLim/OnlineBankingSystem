package com.onlinebankingsystem.dao.interfaces;

import com.onlinebankingsystem.account.Account;

public interface InterfaceAccountDao {
	Account getById(int accountId);

	void save(Account account); // created due to ambiguous after second merge 

}
                 