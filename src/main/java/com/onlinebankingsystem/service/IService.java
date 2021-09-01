package com.onlinebankingsystem.service;

import java.util.List;

import com.onlinebankingsystem.login.Login;
import com.onlinebankingsystem.users.User;

public interface IService {
	
	List<User> getAllUsers();

	User getUser(int id);

	User saveUser(User user);

	User deleteUser(int id);

	User getUserByLogin(Login login);
	
//	List<User> findByIdOrName(int id, String name);
}
