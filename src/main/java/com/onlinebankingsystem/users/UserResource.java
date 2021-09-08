package com.onlinebankingsystem.users;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.onlinebankingsystem.service.IService;

@RestController
//@CrossOrigin("*")
public class UserResource {

	@Autowired
	private IService service;
	
	public UserResource() {
		System.out.println("Inside default constructor of UserResource");
	}
	
	@PostMapping(path="/users")		
	public User createUser(@Valid @RequestBody User user) {
		System.out.println("Inside createUser() of UserResource");
		return service.save(user);
	}
	
//	@RequestMapping(value="/users", method=RequestMethod.GET)
	@GetMapping(path="/users")
	public List<User> retrieveAllUsers() {
		System.out.println("Inside retrieveAllUsers() of UserResource");
		return service.findAll();
	}

	@RequestMapping(value="/users/{id}", method=RequestMethod.GET)
	public User retrieveUser(@PathVariable("id") int id) {
		System.out.println("Inside retrieveOneUser() for ID: "+id+" of UserResource");
		User u = service.findOneUser(id);
		if (u==null) {
			throw new UserNotFoundException("User with ID: "+id+" not found!");
		}		
		return u;
	}
	
	@DeleteMapping(path="/users/{id}")
	public User deleteUser(@PathVariable int id) {
		System.out.println("Inside deleteOneUser() of UserResource");
		return service.deleteOneUser(id);
	}
	
	@GetMapping(path = "/users/{id}/{name}")
	public List<User> findByIdOrName(@PathVariable("id") int id, @PathVariable("name") String name) {
		System.out.println("Inside findByIdOrName() of UserResource "+id+" "+name);
		return service.findByIdOrName(id, name);
	}
}

