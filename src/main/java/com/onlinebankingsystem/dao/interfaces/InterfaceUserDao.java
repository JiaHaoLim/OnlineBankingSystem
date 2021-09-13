package com.onlinebankingsystem.dao.interfaces;

import java.util.List;
import java.util.Optional;

import com.onlinebankingsystem.users.User;

public interface InterfaceUserDao {
	
	Optional<User> findByUsername(String username);

	List<User> findAll();

	Optional<User> findById(int id);

	void save(User user);

	void deleteById(int id);

}
