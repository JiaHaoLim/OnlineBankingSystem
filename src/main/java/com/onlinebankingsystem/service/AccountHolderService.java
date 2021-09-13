package com.onlinebankingsystem.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import com.onlinebankingsystem.dao.AccountHolderJpaRepository;
import com.onlinebankingsystem.service.interfaces.InterfaceAccountHolderService;
import com.onlinebankingsystem.users.AccountHolder;

@Service
public class AccountHolderService implements InterfaceAccountHolderService {
	
	@Autowired
	@Qualifier(value = "AccountHolderJpaRepository")
	private AccountHolderJpaRepository accountHolderDao;

	@Override
	public boolean modifyMobile(int accountHolderId, String mobileNumber) {
		AccountHolder accountHolder = accountHolderDao.getById(accountHolderId);
		accountHolder.setMobileNumber(mobileNumber);
		accountHolderDao.save(accountHolder);
		
		int tempId = accountHolder.getId();
		Optional<AccountHolder> tempOptAccountHolder = accountHolderDao.findById(tempId);
		
		if (tempOptAccountHolder.isPresent() && tempOptAccountHolder.get().getMobileNumber().equals(mobileNumber)) {
			return true;
		} else {
			return false;
		}
	}

	@Override
	public boolean modifyAddress(int accountHolderId, String address) {
		AccountHolder accountHolder = accountHolderDao.getById(accountHolderId);
		accountHolder.setAddress(address);
		accountHolderDao.save(accountHolder);
		
		int tempId = accountHolder.getId();
		Optional<AccountHolder> tempOptAccountHolder = accountHolderDao.findById(tempId);
		
		if (tempOptAccountHolder.isPresent() && tempOptAccountHolder.get().getAddress().equals(address)) {
			return true;
		} else {
			return false;
		}
	}
}
