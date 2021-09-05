package com.onlinebankingsystem.controller;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.Validator;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

import com.onlinebankingsystem.exception.IncorrectLoginPasswordException;
import com.onlinebankingsystem.exception.IncorrectLoginUsernameException;
import com.onlinebankingsystem.exception.LockedUserException;
import com.onlinebankingsystem.login.Login;
import com.onlinebankingsystem.service.IService;
import com.onlinebankingsystem.users.User;

@Controller
public class UserController {
	public static final String MODEL_ATTRIBUTE_LOGIN = "login";
	public static final String MODEL_ATTRIBUTE_SECRET = "secret";
	
	@Autowired
	IService service;
	
	@Autowired
	@Qualifier(value = "loginValidator")
	private Validator loginValidator;
	
	@GetMapping("/")
	public String frontPage(Model model) {
		model.addAttribute(MODEL_ATTRIBUTE_LOGIN, new Login());
        return "login";
    }
	
	@PostMapping("/login")
    public String login(@ModelAttribute(MODEL_ATTRIBUTE_LOGIN) Login login, BindingResult result, Model model) {
		loginValidator.validate(login, result);

		if (result.hasErrors()) {
			return "login";
		} else {
			try {
				User user = service.getUserByLogin(login);
				model.addAttribute("user", user);
				return "home";
			} catch (IncorrectLoginUsernameException ilue) {
				result.rejectValue("username", ilue.getMessage());
				return "login";
			} catch (IncorrectLoginPasswordException ilpe) {
				result.rejectValue("username", ilpe.getMessage());
				service.addNumFailedLogins(ilpe.getUser());
				return "login";
			} catch (LockedUserException lue) {
				Login secret = new Login();
				secret.setUsername(lue.getUser().getSecretQuestion());
				model.addAttribute("secret", secret);
				return "unlockaccount";
			}
		}
    }
	
	@PostMapping("/unlockaccount")
	public String unlockAccount(@ModelAttribute(MODEL_ATTRIBUTE_SECRET) Login secret, BindingResult result, Model model) {
		loginValidator.validate(secret, result);
		
		return "home";
	}
}

