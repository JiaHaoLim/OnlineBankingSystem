package com.onlinebankingsystem.service.interfaces;

import java.util.List;

import com.onlinebankingsystem.users.Login;
import com.onlinebankingsystem.users.User;

public interface InterfaceUserService {
	
	List<User> getAllUsers();

	User getUser(int id);

	void saveUser(User user);

	void deleteUser(int id);

	User getUserByLogin(Login login);

	void addNumFailedLogins(User user);

	boolean unlockUser(Login login, Login secret);
}
