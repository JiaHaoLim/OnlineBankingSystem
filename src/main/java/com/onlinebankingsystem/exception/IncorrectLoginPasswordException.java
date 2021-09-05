package com.onlinebankingsystem.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

import com.onlinebankingsystem.users.User;

@ResponseStatus(code = HttpStatus.NOT_FOUND)
public class IncorrectLoginPasswordException extends RuntimeException {
	private User user;
	
	public IncorrectLoginPasswordException() {
		super("login.username.error.incorrect_username_or_password");
	}
	
	public IncorrectLoginPasswordException(User user) {
		this();
		this.user = user;
	}
	
	public User getUser() {
		return user;
	}
}
