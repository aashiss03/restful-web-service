package com.in28minutes.rest.webservices.restfulwebservices.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.in28minutes.rest.webservices.restfulwebservices.user.User;
import com.in28minutes.rest.webservices.restfulwebservices.user.UserDaoService;

@RestController
public class UserResource {
	
	@Autowired
	private UserDaoService userServive;
	
	@GetMapping("/users")
	public List<User> retrieveAllUsers() {
		return userServive.findAll();
	}
	
	@GetMapping("/users/{id}")
	public User retrieveUser(@PathVariable int id) {
		return userServive.findOne(id);
	}
	
	@PostMapping("/users")
	public User createUser(@RequestBody User user) {
		User savedUser =  userServive.saveUser(user);
		return savedUser;
	}

}
