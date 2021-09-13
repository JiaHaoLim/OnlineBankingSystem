package com.onlinebankingsystem.controller;

import java.util.Map;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.Validator;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.SessionAttributes;

import com.onlinebankingsystem.dao.UserJpaRepository;
import com.onlinebankingsystem.exception.IncorrectLoginPasswordException;
import com.onlinebankingsystem.exception.IncorrectLoginUsernameException;
import com.onlinebankingsystem.exception.IncorrectSecretAnswerException;
import com.onlinebankingsystem.exception.LockedUserException;
import com.onlinebankingsystem.service.InterfaceUserService;
import com.onlinebankingsystem.users.AccountHolder;
import com.onlinebankingsystem.users.BankAdmin;
import com.onlinebankingsystem.users.Login;
import com.onlinebankingsystem.users.LoginValidator;
import com.onlinebankingsystem.users.User;

@RestController
//@SessionAttributes({"login", "secret", "user"}) //Possibly unsafe? Need more research during integration
public class UserController {
//	public static final String MODEL_ATTRIBUTE_LOGIN = "login";
//	public static final String MODEL_ATTRIBUTE_SECRET = "secret";
//	public static final String MODEL_ATTRIBUTE_USER = "user";
	
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
	
//	@GetMapping("/")
//	public String frontPage(Model model) {
////		service.saveUser(new BankAdmin("Alice", "alicE", "A123", "What are your initials?", "A"));
////		service.saveUser(new AccountHolder("Bobby", "BobbY", "B123", "What are your initials?", "B", "wherever Bobby lives", "98765432", "bob@email.com"));
//		model.addAttribute(MODEL_ATTRIBUTE_LOGIN, new Login());
//        return JSP_LOGIN;
//    }
	
//	@PostMapping(URL_LOGIN)
//    public String login(@ModelAttribute(MODEL_ATTRIBUTE_LOGIN) Login login, BindingResult result, Model model) {
//		LoginValidator loginValidator = new LoginValidator();
//		loginValidator.validate(login, result);
//
//		if (result.hasErrors()) {
//			return JSP_LOGIN;
//		} else {
//			try {
//				User user = service.getUserByLogin(login);
//				model.addAttribute(MODEL_ATTRIBUTE_USER, user);
//				return getWelcomeByUserType(user);
//			} catch (IncorrectLoginUsernameException ilue) {
//				result.rejectValue("username", ilue.getMessage());
//				return JSP_LOGIN;
//			} catch (IncorrectLoginPasswordException ilpe) {
//				result.rejectValue("username", ilpe.getMessage());
//				service.addNumFailedLogins(ilpe.getUser());
//				return JSP_LOGIN;
//			} catch (LockedUserException lue) {
//				Login secret = new Login();
//				secret.setUsername(lue.getSecretQuestion());
//				model.addAttribute(MODEL_ATTRIBUTE_SECRET, secret);
//				return JSP_UNLOCK;
//			}
//		}
//    }
//	
//	@PostMapping(URL_UNLOCK)
//	public String unlockAccount(@ModelAttribute(MODEL_ATTRIBUTE_LOGIN) Login login, 
//								@ModelAttribute(MODEL_ATTRIBUTE_SECRET) Login secret, 
//								BindingResult result, Model model) {
//		LoginValidator secretValidator = new LoginValidator(true);
//		secretValidator.validate(secret, result);
//		
//		Login temp = (Login) model.getAttribute(MODEL_ATTRIBUTE_LOGIN);
//		
//		if (result.hasErrors()) {
//			return JSP_UNLOCK;
//		} else {
//			try {
//				User user = service.unlockUser(login, secret);
//				model.addAttribute(MODEL_ATTRIBUTE_USER, user);
//				return getWelcomeByUserType(user);
//			} catch (IncorrectSecretAnswerException isae) {
//				result.rejectValue("password", isae.getMessage());
//				return JSP_UNLOCK;
//			}
//		}
//	}
//	
//	private String getWelcomeByUserType(User user) {
//		if (user instanceof AccountHolder) {
//			return JSP_HOME_ACCOUNT_HOLDER;
//		} else if (user instanceof BankAdmin) {
//			return JSP_HOME_BANK_ADMIN;
//		}
//		return JSP_LOGIN;
//	}
}

