package com.onlinebankingsystem.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.onlinebankingsystem.service.InterfaceAccountHolderService;

@RestController
public class AccountHolderController {
	public static final String ACCOUNT_HOLDER_ID = "account_holder_id";
	public static final String URL_MODIFY_MOBILE = "/accountholder/{" + ACCOUNT_HOLDER_ID + "}/modify/mobile";
	public static final String URL_MODIFY_ADDRESS = "/accountholder/{" + ACCOUNT_HOLDER_ID + "}/modify/address";

	@Autowired
	InterfaceAccountHolderService service;
	
	@PostMapping(URL_MODIFY_MOBILE)
	public boolean modifyMobile(@PathVariable(ACCOUNT_HOLDER_ID) int accountHolderId, @RequestBody String mobileNumber) {
		return service.modifyMobile(accountHolderId, mobileNumber);
	}

	@PostMapping(URL_MODIFY_ADDRESS)
	public boolean modifyAddress(@PathVariable(ACCOUNT_HOLDER_ID) int accountHolderId, @RequestBody String address) {
		return service.modifyAddress(accountHolderId, address);
	}
}
