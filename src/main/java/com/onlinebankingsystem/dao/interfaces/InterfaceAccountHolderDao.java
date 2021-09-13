package com.onlinebankingsystem.dao.interfaces;

import java.util.Optional;

import com.onlinebankingsystem.users.AccountHolder;

public interface InterfaceAccountHolderDao {

	AccountHolder getById(int accountHolderId);

	void save(AccountHolder accountHolder);

	Optional<AccountHolder> findById(int tempId);

}
