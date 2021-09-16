package com.onlinebankingsystem.users;

import javax.persistence.Column;
import javax.persistence.MappedSuperclass;

@MappedSuperclass
public class Login {
	public static final String USERNAME_COLUMN = "username";
	@Column(name = USERNAME_COLUMN, nullable = false, unique = true)
	protected String username;
	
	public static final String PASSWORD_COLUMN = "password";
	@Column(name = PASSWORD_COLUMN, nullable = false)
	protected String password;
	
	public Login(String username, String password) {
		this.username = username;
		this.password = password;
	}

	public Login() {}

	public String getUsername() {
		return username;
	}

	public String getPassword() {
		return password;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public void setPassword(String password) {
		this.password = password;
	}
}
