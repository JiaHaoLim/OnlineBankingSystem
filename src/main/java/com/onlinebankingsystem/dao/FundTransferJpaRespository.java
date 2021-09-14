package com.onlinebankingsystem.dao;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.onlinebankingsystem.account.Account;
import com.onlinebankingsystem.dao.interfaces.InterfaceFundTransferDao;



@Repository(value = "FundTransferJpaRespository")
public interface FundTransferJpaRespository extends InterfaceFundTransferDao, JpaRepository<Account, Double> {
	 
	Optional<Account> findByAccountNumber(String AccountNumber ); // optional can return null


	

	


}
