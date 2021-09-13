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

import com.onlinebankingsystem.newAccount.Account;
import com.onlinebankingsystem.newAccount.AccountValidator;
import com.onlinebankingsystem.service.InterfaceAccountService;

@Controller
public class AccountController {
	
	@Autowired
	private InterfaceAccountService accService; 
	
	@Autowired
	private AccountValidator validator;
	
	@GetMapping(path ="/create")
	public String CreatingAccForm(Account a)
	{
		return "newaccount";
		
	}
	
	
	@PostMapping(path = "/create")
   // @Transactional(propagation = Propagation.REQUIRED)
	public String CreateNewAcc(@Valid @ModelAttribute("acc") Account a, BindingResult result){
		System.out.println("Inside CreateNewAcc()");
		System.out.println(a);
		//invoking validator before invoking the service layer
		validator.validate(a, result);
		if(result.hasErrors())
		{
			return "newaccount";
		}
		
		
		accService.saveAccount(a);
		return "Success";
		
	}
	
	
	
}
