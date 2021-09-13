package com.onlinebankingsystem.newAccount;

import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.ValidationUtils;
import org.springframework.validation.Validator;

@Component(value = "val")
public class AccountValidator implements Validator {

	@Override
	public boolean supports(Class clas) {
		// TODO Auto-generated method stub
		return Account.class.equals(clas);
	}

	@Override
	public void validate(Object target, Errors errors) {
		Account acc =(Account)target;
		ValidationUtils.rejectIfEmpty(errors, "account_type", "account_type.error.null");
		ValidationUtils.rejectIfEmpty(errors, "opening_balance", "opening_balance.error.null");
	}

}
