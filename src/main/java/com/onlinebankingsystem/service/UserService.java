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
		int id = -1;
		try {
			id = Integer.parseInt(login.getId());
		} catch (NumberFormatException nfe) {
			return null;
		}
		Optional<User> user = dao.findById(id);
		if (user.isPresent() && login.getPassword().equals(user.get().getPassword())) {
			return user.get();
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
