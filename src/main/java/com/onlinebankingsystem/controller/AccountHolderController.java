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
	public static final String URL_ACCOUNT_HOLDER = "accountholder/{id}";
	public static final String URL_MINI_STATEMENT = "/accountholder/ministatement/{id}";
	public static final String URL_DETAILED_STATEMENT = "/accountholder/detailedstatement/{id}";
	
	@Autowired
	InterfaceAccountHolderService service;
	
	@GetMapping(URL_MINI_STATEMENT)
	public BankStatement getMiniStatement(@PathVariable("id") int id) {
		return service.getMiniStatement(id);
	}
	
	@GetMapping(URL_DETAILED_STATEMENT)
	public BankStatement getDetailedStatement(@PathVariable("id") int id) {
		return service.getDetailedStatement(id);
	}
}
