package com.onlinebankingsystem.service;

import java.util.List;

import com.onlinebankingsystem.account.BankStatement;
import com.onlinebankingsystem.users.Login;
import com.onlinebankingsystem.users.User;

public interface InterfaceUserService {
	
	List<User> getAllUsers();

	User getUser(int id);

	User saveUser(User user);

	User deleteUser(int id);

	User getUserByLogin(Login login);

	void addNumFailedLogins(User user);

	boolean unlockUser(Login login, Login secret);
}
