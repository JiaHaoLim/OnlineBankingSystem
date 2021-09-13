package com.onlinebankingsystem.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.onlinebankingsystem.config.AppConfig;
import com.onlinebankingsystem.dao.UserJpaRepository;
import com.onlinebankingsystem.exception.IncorrectLoginPasswordException;
import com.onlinebankingsystem.exception.IncorrectLoginUsernameException;
import com.onlinebankingsystem.exception.IncorrectSecretAnswerException;
import com.onlinebankingsystem.exception.LockedUserException;
import com.onlinebankingsystem.service.interfaces.InterfaceUserService;
import com.onlinebankingsystem.users.Login;
import com.onlinebankingsystem.users.User;

@Service
public class UserService implements InterfaceUserService {

	public static final int MAX_FAILED_ATTEMPTS = AppConfig.MAX_FAILED_ATTEMPTS; 

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
		Optional<User> optUser = dao.findByUsername(login.getUsername());
		// We need to compare the username because some databases such as MySQL are not
		// case sensitive
		if (optUser.isPresent() && login.getUsername().equals(optUser.get().getUsername())) {
			User user = optUser.get();
			if (login.getPassword().equals(user.getPassword())) {
				if (!user.isLocked()) {
					if (user.getNumFailedLogins() > 0) {
						user.setNumFailedLogins(0);
						dao.save(user);
					}
					return user;
				} else {
					throw new LockedUserException(user.getSecretQuestion());
				}
			} else {
				throw new IncorrectLoginPasswordException(user);
			}
		} else {
			throw new IncorrectLoginUsernameException();
		}
	}

	@Override
	public void addNumFailedLogins(User user) {
		user.addNumFailedLogins();
		if (user.getNumFailedLogins() >= MAX_FAILED_ATTEMPTS) {
			user.setLocked(true);
		}

		dao.save(user);
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

	@Override
	public boolean unlockUser(Login login, Login secret) {
		// unlockUser() should only be called by UserController after calling
		// getUserByLogin().
		// As such, login must be valid user account credentials

		Optional<User> optUser = dao.findByUsername(login.getUsername());

		User user = dao.findByUsername(login.getUsername()).get();

		if (secret.getPassword().toLowerCase().equals(user.getSecretAnswer().toLowerCase())) {
			user.setNumFailedLogins(0);
			user.setLocked(false);
			dao.save(user);
			return true;
		} else {
			throw new IncorrectSecretAnswerException();
		}
	}
}
