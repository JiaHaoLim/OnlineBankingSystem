package com.onlinebankingsystem.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import com.onlinebankingsystem.account.Account;
import com.onlinebankingsystem.account.BankStatement;
import com.onlinebankingsystem.service.InterfaceAccountHolderService;

@RestController
public class AccountHolderController {	
	public static final String ACCOUNT_ID = "account_id";
	public static final String URL_MINI_STATEMENT = "/accountholder/{" + ACCOUNT_ID + "}/ministatement";
	public static final String URL_DETAILED_STATEMENT = "/accountholder/{" + ACCOUNT_ID + "}/detailedstatement";
	
	@Autowired
	InterfaceAccountHolderService service;
	
	@GetMapping(URL_MINI_STATEMENT)
	public BankStatement getMiniStatement(@PathVariable(ACCOUNT_ID) int accountId) {
		return service.getMiniStatement(accountId);
	}
	
	@GetMapping(URL_DETAILED_STATEMENT)
	public BankStatement getDetailedStatement(@PathVariable(ACCOUNT_ID) int accountId) {
		return service.getDetailedStatement(accountId);
	}
}
