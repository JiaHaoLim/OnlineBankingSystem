package com.onlinebankingsystem.exception;

import com.onlinebankingsystem.users.User;

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
