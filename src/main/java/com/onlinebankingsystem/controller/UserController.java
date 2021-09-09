package com.onlinebankingsystem.controller;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.Validator;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.SessionAttributes;

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

@Controller
@SessionAttributes({"login", "secret", "user"}) //Possibly unsafe? Need more research during integration
public class UserController {
	public static final String MODEL_ATTRIBUTE_LOGIN = "login";
	public static final String MODEL_ATTRIBUTE_SECRET = "secret";
	public static final String MODEL_ATTRIBUTE_USER = "user";
	
	public static final String JSP_LOGIN = "login";
	public static final String JSP_WELCOME = "home";
	public static final String JSP_UNLOCK = "unlockaccount";
	
	@Autowired
	InterfaceUserService service;
	
	@GetMapping("/")
	public String frontPage(Model model) {
		model.addAttribute(MODEL_ATTRIBUTE_LOGIN, new Login());
        return JSP_LOGIN;
    }
	
	@PostMapping("/login")
    public String login(@ModelAttribute(MODEL_ATTRIBUTE_LOGIN) Login login, BindingResult result, Model model) {
		LoginValidator loginValidator = new LoginValidator();
		loginValidator.validate(login, result);

		if (result.hasErrors()) {
			return JSP_LOGIN;
		} else {
			try {
				User user = service.getUserByLogin(login);
				model.addAttribute(MODEL_ATTRIBUTE_USER, user);
				return getWelcomeByUserType(user);
			} catch (IncorrectLoginUsernameException ilue) {
				result.rejectValue("username", ilue.getMessage());
				return JSP_LOGIN;
			} catch (IncorrectLoginPasswordException ilpe) {
				result.rejectValue("username", ilpe.getMessage());
				service.addNumFailedLogins(ilpe.getUser());
				return JSP_LOGIN;
			} catch (LockedUserException lue) {
				Login secret = new Login();
				secret.setUsername(lue.getSecretQuestion());
				model.addAttribute(MODEL_ATTRIBUTE_SECRET, secret);
				return JSP_UNLOCK;
			}
		}
    }
	
	@PostMapping("/unlockaccount")
	public String unlockAccount(@ModelAttribute(MODEL_ATTRIBUTE_LOGIN) Login login, 
								@ModelAttribute(MODEL_ATTRIBUTE_SECRET) Login secret, 
								BindingResult result, Model model) {
		LoginValidator secretValidator = new LoginValidator(true);
		secretValidator.validate(secret, result);
		
		System.out.println(login.getUsername());
		Login temp = (Login) model.getAttribute(MODEL_ATTRIBUTE_LOGIN);
		System.out.println(temp.getUsername());
		
		if (result.hasErrors()) {
			return JSP_UNLOCK;
		} else {
			try {
				User user = service.unlockUser(login, secret);
				model.addAttribute(MODEL_ATTRIBUTE_USER, user);
				return getWelcomeByUserType(user);
			} catch (IncorrectSecretAnswerException isae) {
				result.rejectValue("password", isae.getMessage());
				return JSP_UNLOCK;
			}
		}
	}
	
	private String getWelcomeByUserType(User user) {
		if (user instanceof AccountHolder) {
			return JSP_WELCOME;
		} else if (user instanceof BankAdmin) {
			return JSP_WELCOME;
		}
		return JSP_LOGIN;
	}
}

