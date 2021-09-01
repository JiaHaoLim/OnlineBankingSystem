package com.onlinebankingsystem.login;

import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.ValidationUtils;
import org.springframework.validation.Validator;

import com.onlinebankingsystem.users.User;

@Component(value = "loginValidator")
public class LoginValidator implements Validator {

	@Override
	public boolean supports(Class clas) {
		return Login.class.equals(clas);
	}

	@Override
	public void validate(Object target, Errors errors) {
		Login login = (Login) target;
		ValidationUtils.rejectIfEmpty(errors, "id", "login.id.error.null");
		try {
			int id = Integer.parseInt(login.getId());
		} catch (NumberFormatException nfe) {
			errors.reject("id", "login.id.error.incorrect_id_or_password");
		}
		ValidationUtils.rejectIfEmpty(errors, "password", "login.password.error.null");
	}

}
