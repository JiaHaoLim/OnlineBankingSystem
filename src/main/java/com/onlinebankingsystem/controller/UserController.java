package com.onlinebankingsystem.controller;

import java.net.URI;
import java.net.URISyntaxException;
import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.Validator;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.onlinebankingsystem.dao.UserJpaRepository;
import com.onlinebankingsystem.exception.IncorrectLoginPasswordException;
import com.onlinebankingsystem.exception.IncorrectLoginUsernameException;
import com.onlinebankingsystem.exception.LockedUserException;
import com.onlinebankingsystem.login.Login;
import com.onlinebankingsystem.service.IService;
import com.onlinebankingsystem.users.User;

//@RestController
@Controller
@CrossOrigin("*")
//@RequestMapping("/users")
public class UserController {
//	private final UserJpaRepository userJpaRepository;
//	
//	public UserController(UserJpaRepository userJpaRepository) {
//		this.userJpaRepository = userJpaRepository;
//	}
//	
//	  	@GetMapping
//	    public List<User> getUsers() {
//	        return userJpaRepository.findAll();
//	    }
//
//	    @GetMapping("/{id}")
//	    public User getUsers(@PathVariable Long id) {
//	        return userJpaRepository.findById(id).orElseThrow(RuntimeException::new);
//	    }
//
//	    @PostMapping
//	    public ResponseEntity createUser(@RequestBody User user) throws URISyntaxException {
//	        User savedUser = userJpaRepository.save(user);
//	        return ResponseEntity.created(new URI("/users/" + savedUser.getId())).body(savedUser);
//	    }
//
//	    @PutMapping("/{id}")
//	    public ResponseEntity updateUser(@PathVariable Long id, @RequestBody User user) {
//	    	User currentUser = userJpaRepository.findById(id).orElseThrow(RuntimeException::new);
//	    	currentUser.setName(user.getName());
//	    	currentUser.setEmailAddress(user.getEmailAddress());
//	    	currentUser = userJpaRepository.save(user);
//
//	        return ResponseEntity.ok(currentUser);
//	    }
//
//	    @DeleteMapping("/{id}")
//	    public ResponseEntity deleteClient(@PathVariable Long id) {
//	    	userJpaRepository.deleteById(id);
//	        return ResponseEntity.ok().build();
//	    }
	
	
	
	public static final String MODEL_ATTRIBUTE_LOGIN = "login";
	public static final String MODEL_ATTRIBUTE_SECRET = "secret";
	
	@Autowired
	IService service;
	
	@Autowired
	@Qualifier(value = "loginValidator")
	private Validator loginValidator;
	
//	@GetMapping("/login")
//	public String frontPage(Model model) {
//		model.addAttribute(MODEL_ATTRIBUTE_LOGIN, new Login());
//        return "login";
//    }
//	
	@PostMapping("/login")
	public User login(String username, String password, Model model) {
		System.out.println("inside login() of UserController");
		Login login = new Login(username, password);
		model.addAttribute("login", login);
		User user = null;
		try {user = service.getUserByLogin(login);}
		catch (Exception e) {
			System.out.println(e.getMessage());
		}
		return user;	
	}
	
//	@PostMapping("/login")
//    public String login(@ModelAttribute(MODEL_ATTRIBUTE_LOGIN) Login login, BindingResult result, Model model) {
//		loginValidator.validate(login, result);
//
//		if (result.hasErrors()) {
//			return "login";
//		} else {
//			try {
//				User user = service.getUserByLogin(login);
//				model.addAttribute("user", user);
//				return "home";
//			} catch (IncorrectLoginUsernameException ilue) {
//				result.rejectValue("username", ilue.getMessage());
//				return "login";
//			} catch (IncorrectLoginPasswordException ilpe) {
//				result.rejectValue("username", ilpe.getMessage());
//				service.addNumFailedLogins(ilpe.getUser());
//				return "login";
//			} catch (LockedUserException lue) {
//				Login secret = new Login();
//				secret.setUsername(lue.getUser().getSecretQuestion());
//				model.addAttribute("secret", secret);
//				return "unlockaccount";
//			}
//		}
//    }
	
	@PostMapping("/unlockaccount")
	public String unlockAccount(@ModelAttribute(MODEL_ATTRIBUTE_SECRET) Login secret, BindingResult result, Model model) {
		loginValidator.validate(secret, result);
		
		return "home";
	}
}

