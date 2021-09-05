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

import com.onlinebankingsystem.login.Login;
import com.onlinebankingsystem.service.IService;
import com.onlinebankingsystem.users.User;

@Controller
public class UserController {
	@Autowired
	IService service;
	
	@Autowired
	@Qualifier(value = "loginValidator")
	private Validator loginValidator;
	
	@GetMapping("/")
	public String frontPage(Model model) {
		model.addAttribute("login", new Login());
        return "login";
    }
	
	@PostMapping("/login")
    public String login(@ModelAttribute("login") Login login, BindingResult result, Model model) {
		loginValidator.validate(login, result);

		if (result.hasErrors()) {
			return "login";
		} else {
			User user = service.getUserByLogin(login);
			if (user == null) {
				result.rejectValue("username", "login.username.error.incorrect_username_or_password");
				return "login";
			}
			model.addAttribute("user", user);
			return "home";
		}
    }
	
//	@GetMapping("/users")
//	public List<User> retrieveAllUsers() {
//		System.out.println("Inside retrieveUsers() of " + this.getClass());
//		
//		return service.getAllUsers();
//	}
//	
//	@GetMapping("/users/{id}")
//	public User retrieveUser(@PathVariable("id") int id) {
//		System.out.println("Inside retrieveUser() of " + this.getClass());
//		
//		User user = service.getUser(id);
//		if (user == null) {
//			throw new UserNotFoundException("User with User ID: " + id + " not found!");
//		}
//		return user;
//	}
//	
//	@PostMapping("/users")
//	public User createUser(@Valid @RequestBody User user) {
//		System.out.println("Inside saveUser() of " + this.getClass());
//		return service.saveUser(user);
//	}
//	
//	@DeleteMapping("/users/{id}")
//	public User deleteUser(@PathVariable("id") int id) {
//		System.out.println("Inside deleteUser() of " + this.getClass());
//		return service.deleteUser(id);
//	}
	
//	@GetMapping("/users/{id}/{name}")
//	public List<User> findByIdOrName(@PathVariable("id") int id, @PathVariable("name") String name) {
//		System.out.println("Inside findByIdOrName() of " + this.getClass());
//		return service.findByIdOrName(id, name);
//	}
}

