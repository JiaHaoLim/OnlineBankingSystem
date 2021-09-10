package com.onlinebankingsystem.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RestController;

import com.onlinebankingsystem.account.Account;
import com.onlinebankingsystem.account.BankStatement;
import com.onlinebankingsystem.service.InterfaceAccountHolderService;

@RestController
public class AccountHolderController {
	public static final String JSP_MINI_STATEMENT = "ministatement";
	public static final String JSP_DETAILED_STATEMENT = "detailedstatement";
	
	public static final String URL_MINI_STATEMENT = "/" + JSP_MINI_STATEMENT;
	public static final String URL_DETAILED_STATEMENT = "/" + JSP_DETAILED_STATEMENT;
	
	@Autowired
	InterfaceAccountHolderService service;
	
	@GetMapping(URL_MINI_STATEMENT)
	public BankStatement getMiniStatement(@ModelAttribute("account") Account account) {
		return service.getMiniStatement(account);
	}
	
	@GetMapping(URL_DETAILED_STATEMENT)
	public BankStatement getDetailedStatement(@ModelAttribute("account") Account account) {
		return service.getDetailedStatement(account);
	}
}
