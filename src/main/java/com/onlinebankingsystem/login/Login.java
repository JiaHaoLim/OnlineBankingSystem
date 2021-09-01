package com.onlinebankingsystem.login;

public class Login {
	private String id;
	private String password;
	
	public Login(String id, String password) {
		this.id = id;
		this.password = password;
	}

	public Login() {}

	public String getId() {
		return id;
	}

	public String getPassword() {
		return password;
	}

	public void setId(String id) {
		this.id = id;
	}

	public void setPassword(String password) {
		this.password = password;
	}
}
