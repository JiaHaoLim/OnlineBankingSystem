package com.onlinebankingsystem.exception;

public class IncorrectLoginUsernameException extends RuntimeException {
	public IncorrectLoginUsernameException() {
		super("login.username.error.incorrect_username_or_password");
	}
}
