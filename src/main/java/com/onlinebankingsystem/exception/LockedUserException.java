package com.onlinebankingsystem.exception;

import com.onlinebankingsystem.users.User;

public class LockedUserException extends RuntimeException {
	private User user;
	
	public LockedUserException(User user) {
		this.user = user;
	}
	
	public User getUser() {
		return user;
	}
}
