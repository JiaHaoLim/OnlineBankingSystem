package com.onlinebankingsystem.controller;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mapping.AccessOptions.SetOptions.Propagation;
import org.springframework.stereotype.Controller;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.onlinebankingsystem.account.Account;

import com.onlinebankingsystem.service.InterfaceAccountService;

@Controller
public class AccountController {

//	public static final String CREATATION_OF_ACCOUNT = "create";
//	public static final String URL_CREATE_ACC = "/" + CREATATION_OF_ACCOUNT;

	@Autowired
	private InterfaceAccountService accountService;

	@GetMapping(path = "/create")
	public String CreatingAccForm(Account a) {
		return "newaccount";

	}

	@PostMapping(path = "/create")
	// @Transactional(propagation = Propagation.REQUIRED)
	public String CreateNewAcc(Account a) {
		System.out.println("Inside CreateNewAcc()");
		System.out.println(a);

		accountService.saveAccount(a);
		return "Success";

	}
}
