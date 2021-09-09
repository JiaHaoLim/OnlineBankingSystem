package com.onlinebankingsystem.dao;

import java.util.List;
import java.util.Optional;

import com.onlinebankingsystem.users.User;

public interface InterfaceUserDao {
	
	Optional<User> findByLoginUsername(String loginUsername);

}
