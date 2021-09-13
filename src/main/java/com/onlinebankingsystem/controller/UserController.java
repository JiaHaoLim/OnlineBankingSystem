package com.onlinebankingsystem.controller;

import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import com.onlinebankingsystem.exception.IncorrectLoginPasswordException;
import com.onlinebankingsystem.exception.IncorrectLoginUsernameException;
import com.onlinebankingsystem.exception.IncorrectSecretAnswerException;
import com.onlinebankingsystem.exception.LockedUserException;
import com.onlinebankingsystem.service.interfaces.InterfaceUserService;
import com.onlinebankingsystem.users.Login;
import com.onlinebankingsystem.users.User;

@RestController
public class UserController {	
	public static final String URL_LOGIN = "/login";
	public static final String URL_UNLOCK = "/unlockaccount";
	
	@Autowired
	InterfaceUserService service;
	
	@CrossOrigin
	@PostMapping(URL_LOGIN)
	public Login login(@RequestBody Login login) {
		try {
			User user = service.getUserByLogin(login);
			return user;
		} catch (IncorrectLoginUsernameException ilue) {
			return null;
		} catch (IncorrectLoginPasswordException ilpe) {
			service.addNumFailedLogins(ilpe.getUser());
			return null;
		} catch (LockedUserException lue) {
			Login secret = new Login();
			secret.setUsername(lue.getSecretQuestion());
			return secret;
		}
	}
	
	@CrossOrigin
	@PostMapping(URL_UNLOCK)
	public boolean unlockAccount(@RequestBody Map<String, Login> body) {
		Login login = body.get("login");
		Login secret = body.get("secret");
		
		try {
			return service.unlockUser(login, secret);
		} catch (IncorrectSecretAnswerException isae) {
			return false;
		}
	}
}

