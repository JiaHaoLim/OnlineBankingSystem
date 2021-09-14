package com.onlinebankingsystem.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import com.onlinebankingsystem.service.FundTransferService;

@RestController
//@Controller
public class FundTransferController {
	
	public static final String URL_FUND_TRANSFER ="/transfer";

	@Autowired
	private FundTransferService service;

//	@GetMapping(URL_FUND_TRANSFER)
////	@Transactional(propagation = Propagation.REQUIRED)
//	public String TransferingFunds() {
//
//		return "fundtransfer";
//
//	}
	
	@GetMapping(URL_FUND_TRANSFER)
//	@Transactional(propagation = Propagation.REQUIRED)
	public boolean TransferingFunds() {

		return true;

	}

//	@PostMapping(URL_FUND_TRANSFER)
//	@Transactional(propagation = Propagation.REQUIRED)
//	public String TranferFundsResult(String a, String b, double amountXfer) {
//		service.transfer(a, b, amountXfer);
//		return "Success";
//	}
	
	@PostMapping(URL_FUND_TRANSFER)
	@Transactional(propagation = Propagation.REQUIRED)
	public boolean TranferFundsResult(String a, String b, double amountXfer) {
		service.transfer(a, b, amountXfer);
		return true;
	}

}
