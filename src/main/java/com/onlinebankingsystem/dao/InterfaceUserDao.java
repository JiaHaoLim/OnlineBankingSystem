package com.onlinebankingsystem.dao;

import java.util.Optional;

import com.onlinebankingsystem.users.User;

public interface InterfaceUserDao {
	
	Optional<User> findByUsername(String username);

}
