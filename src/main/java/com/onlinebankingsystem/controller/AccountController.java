package com.onlinebankingsystem.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import com.onlinebankingsystem.account.Account;
import com.onlinebankingsystem.account.BankStatement;
import com.onlinebankingsystem.service.interfaces.InterfaceAccountService;


//@Controller
@RestController
public class AccountController {

//	public static final String CREATATION_OF_ACCOUNT = "create";
//	public static final String URL_CREATE_ACC = "/" + CREATATION_OF_ACCOUNT;
	public static final String ACCOUNT_ID = "account_id";
	public static final String URL_MINI_STATEMENT = "/account/{" + ACCOUNT_ID + "}/ministatement";
	public static final String URL_DETAILED_STATEMENT = "/account/{" + ACCOUNT_ID + "}/detailedstatement";

	@Autowired
	private InterfaceAccountService accountService;

//	@GetMapping(path = "/create")
//	public String CreatingAccForm(Account a) {
//		return "newaccount";
//
//	}
	@GetMapping(path = "/create")
	public Account CreatingAccForm(Account a) {
		return a;

	}

//	@PostMapping(path = "/create")
//	// @Transactional(propagation = Propagation.REQUIRED)
//	public String CreateNewAcc(Account a) {
//		
//		System.out.println(a);
//
//		accountService.saveAccount(a);
//		return "Success";
//
//	}
	@PostMapping(path = "/create")
	// @Transactional(propagation = Propagation.REQUIRED)
	public boolean CreateNewAcc(Account a) {
		
		System.out.println(a);

		accountService.saveAccount(a);
		return true;

	}
	
	@GetMapping(URL_MINI_STATEMENT)
	public BankStatement getMiniStatement(@PathVariable(ACCOUNT_ID) int accountId) {
		return accountService.getMiniStatement(accountId);
	}

	@GetMapping(URL_DETAILED_STATEMENT)
	public BankStatement getDetailedStatement(@PathVariable(ACCOUNT_ID) int accountId) {
		return accountService.getDetailedStatement(accountId);
	}
}
