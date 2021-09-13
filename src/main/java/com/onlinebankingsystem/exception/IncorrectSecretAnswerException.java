package com.onlinebankingsystem.exception;

public class IncorrectSecretAnswerException extends RuntimeException {
	public IncorrectSecretAnswerException() {
		super("secret.password.error.incorrect");
	}
}
