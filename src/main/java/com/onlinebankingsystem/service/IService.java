package com.onlinebankingsystem.service;

import java.util.List;

import com.onlinebankingsystem.login.Login;
import com.onlinebankingsystem.users.User;

public interface IService {
	
	public List<User> getAllUsers();

	public User getUser(int id);

	public User saveUser(User user);

	public User deleteUser(int id);

	public User getUserByLogin(Login login);

	public void addNumFailedLogins(User user);
	
//	public List<User> findByIdOrName(int id, String name);
}
