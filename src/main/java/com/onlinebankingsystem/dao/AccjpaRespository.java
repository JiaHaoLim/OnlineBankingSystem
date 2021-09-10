package com.onlinebankingsystem.dao;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.onlinebankingsystem.newAccount.Account;

@Repository(value = "AccJpaRepository")
public interface AccjpaRespository extends IAccDao, JpaRepository<Account, Integer> {


	
	
	//Optional<AccountPage> save( String account_type , String opening_blance);
}
