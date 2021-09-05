package com.onlinebankingsystem.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.onlinebankingsystem.dao.UserJpaRepository;
import com.onlinebankingsystem.login.Login;
import com.onlinebankingsystem.users.User;

@Service
public class UserService implements IService {
	
	public static final int MAX_FAILED_ATTEMPTS = 3;
	
	@Autowired
	@Qualifier(value = "UserJpaRepository")
	private UserJpaRepository dao;

	@Override
	@Transactional(propagation = Propagation.REQUIRED)
	public List<User> getAllUsers() {
		return dao.findAll();
	}

	@Override
	@Transactional(propagation = Propagation.REQUIRED)
	public User getUser(int id) {
		return dao.findById(id).get();
	}
	
	@Override
	@Transactional(propagation = Propagation.REQUIRED)
	public User getUserByLogin(Login login) {
		Optional<User> optUser = dao.findByLoginUsername(login.getUsername());
		if (optUser.isPresent()) {
			User user = optUser.get();
			//We need to compare the username because some databases such as MySQL are not case sensitive
			if (login.getUsername().equals(user.getLoginUsername()) && 
				login.getPassword().equals(user.getLoginPassword())) {
				
				if (user.getNumFailedLogins() > 0) {
					user.setNumFailedLogins(0);
					dao.save(user);
				}
				System.out.println(login.getUsername());
				return user;
			} else {
				user.addNumFailedLogins();
				if (user.getNumFailedLogins() >= MAX_FAILED_ATTEMPTS) {
					user.setLocked(true);
				}
				
				dao.save(user);
				return null;
			}
		} else {
			return null;
		}
	}

	@Override
	@Transactional(propagation = Propagation.REQUIRED)
	public User saveUser(User user) {
		return dao.save(user);
	}

	@Override
	@Transactional(propagation = Propagation.REQUIRED)
	public User deleteUser(int id) {
		dao.deleteById(id);
		return null;
	}
	
//	@Override
//	@Transactional(propagation = Propagation.REQUIRED)
//	public List<User> findByIdOrName(int id, String name) {
//		System.out.println("Inside findByIdOrName() of " + this.getClass());
//		
//		return dao.findByIdOrName(id, name);
//	}
}
