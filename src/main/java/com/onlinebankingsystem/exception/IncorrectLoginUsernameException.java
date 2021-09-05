package com.onlinebankingsystem.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

import com.onlinebankingsystem.users.User;

@ResponseStatus(code = HttpStatus.NOT_FOUND)
public class IncorrectLoginUsernameException extends RuntimeException {
	public IncorrectLoginUsernameException() {
		super("login.username.error.incorrect_username_or_password");
	}
}
