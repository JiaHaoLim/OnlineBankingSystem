package com.onlinebankingsystem.exception;

public class LockedUserException extends RuntimeException {
	private String secretQuestion;
	
	public LockedUserException(String secretQuestion) {
		this.secretQuestion = secretQuestion;
	}
	
	public String getSecretQuestion() {
		return secretQuestion;
	}
}
