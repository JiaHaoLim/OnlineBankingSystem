package com.onlinebankingsystem.users;

import org.springframework.validation.Errors;
import org.springframework.validation.ValidationUtils;
import org.springframework.validation.Validator;

public class LoginValidator implements Validator {
	private final boolean isSecret;
	
	public LoginValidator() {
		this.isSecret = false;
	}
	
	public LoginValidator(boolean isSecret) {
		this.isSecret = isSecret;
	}

	@Override
	public boolean supports(Class clas) {
		return Login.class.equals(clas);
	}

	@Override
	public void validate(Object target, Errors errors) {
		Login login = (Login) target;
		if (isSecret) {
			ValidationUtils.rejectIfEmpty(errors, "password", "secret.password.error.null");
		} else {
			ValidationUtils.rejectIfEmpty(errors, "username", "login.username.error.null");
			ValidationUtils.rejectIfEmpty(errors, "password", "login.password.error.null");
		}
	}

}
