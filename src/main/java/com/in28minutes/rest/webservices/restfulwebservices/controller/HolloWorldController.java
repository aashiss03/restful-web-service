package com.in28minutes.rest.webservices.restfulwebservices.controller;

import org.springframework.web.bind.annotation.GetMapping;

import org.springframework.web.bind.annotation.RestController;

@RestController
public class HolloWorldController {

	@GetMapping("/Hello-World")
	public String helloWorld() {

		return "Hello World";
	}

}
