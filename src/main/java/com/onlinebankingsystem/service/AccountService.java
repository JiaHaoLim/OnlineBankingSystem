package com.onlinebankingsystem.service;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.data.mapping.AccessOptions.SetOptions.Propagation;
import org.springframework.stereotype.Service;

import com.onlinebankingsystem.account.Account;
import com.onlinebankingsystem.dao.AccountJpaRepository;


//@Service a specialization of @Component annotation. 
//Spring Service annotation can be applied only to classes. 
//It is used to mark the class as a service
@Service
public class AccountService implements InterfaceAccountService {

	@Autowired
	@Qualifier(value = "AccountJpaRepository")
	private AccountJpaRepository dao;

	@Override
	public void saveAccount(Account account) {
		System.out.println("AccService saveAccount()");
		dao.save(account);
		
	}

	

	

	

	
	
	

	
	
}
