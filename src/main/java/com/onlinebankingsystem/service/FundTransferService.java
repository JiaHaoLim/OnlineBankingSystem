package com.onlinebankingsystem.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import com.onlinebankingsystem.account.Account;
import com.onlinebankingsystem.dao.FundTransferJpaRespository;
import com.onlinebankingsystem.dao.interfaces.InterfaceFundTransferDao;
import com.onlinebankingsystem.service.interfaces.InterfaceFundTransferService;

@Service
public class FundTransferService implements InterfaceFundTransferService {

	@Autowired
	@Qualifier(value = "FundTransferJpaRespository")
	private InterfaceFundTransferDao dao;


	@Override
	public boolean transfer(String a, String b, double amountXfer) {
		
//		if(a.getAcc_balance() < amountXfer)
//		{
//			return false;
//		}
//		 double newAbalance = accAbalance - amountXfer;
//		 double newBbalance = accBbalance + amountXfer;
//		 a.setAcc_balance(newAbalance);
//		 b.setAcc_balance(newBbalance);
		
		// calling of withdraw and deposit method 
		 Optional <Account> optAcc1 = dao.findByAccountNumber(a);
		 Optional <Account> optAcc2 = dao.findByAccountNumber(b);
		 if (optAcc1.isPresent()&& a.equals(optAcc1.get().getAccountNumber())) {
			 Account accountA = optAcc1.get();
			 if (optAcc1.isPresent()&& a.equals(optAcc1.get().getAccountNumber())) {
				 Account accountB = optAcc2.get();
				 accountA.withdaw(amountXfer);
				 accountB.deposit(amountXfer);
				 dao.save(accountA);
				 dao.save(accountB);
			 }
		}
		 
//		 a.withdaw(amountXfer);
//		 b.deposit(amountXfer);
//		 dao.save(a);
//		 dao.save(b);
	
		 return true;
		
	}



}
