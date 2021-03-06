package com.in28minutes.rest.webservices.restfulwebservices.controller;

import java.net.URI;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import com.in28minutes.rest.webservices.restfulwebservices.exception.UserNotFoundException;
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
		User user= userServive.findOne(id);
		if (user==null)
			throw new UserNotFoundException("id-"+id);
		 
		 return user;
	}
	
	@PostMapping("/users")
	public ResponseEntity createUser(@RequestBody User user) {
		User savedUser =  userServive.saveUser(user);
		URI uri= ServletUriComponentsBuilder.fromCurrentRequest().path("/{path}").
		buildAndExpand(savedUser.getId()).toUri();
		return ResponseEntity.created(uri).build();
	}

}
