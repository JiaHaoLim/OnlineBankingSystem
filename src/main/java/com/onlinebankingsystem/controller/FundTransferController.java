package com.onlinebankingsystem.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import com.onlinebankingsystem.account.Account;
import com.onlinebankingsystem.service.FundTransferService;

@Controller
public class FundTransferController {

	@Autowired
	private FundTransferService service;

	@GetMapping(path = "/transfer")
//	@Transactional(propagation = Propagation.REQUIRED)
	public String TransferingFunds() {

		return "fundtransfer";

	}

	@PostMapping(path = "/transfer")
	@Transactional(propagation = Propagation.REQUIRED)
	public String TranferFundsResult(String a, String b, double amountXfer) {
		service.transfer(a, b, amountXfer);
		return "Success";
	}

}
