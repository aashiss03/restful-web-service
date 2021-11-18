package com.in28minutes.rest.webservices.restfulwebservices.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import com.in28minutes.rest.webservices.restfulwebservices.model.HelloWorldBean;

@RestController
public class HolloWorldController {

	@GetMapping("/Hello-World")
	public String helloWorld() {

		return "Hello World";
	}
	@GetMapping("/Hello-World-Bean")
	public HelloWorldBean helloWorldBean() {

	return new HelloWorldBean("Hello-World-Bean");
	
	}
	@GetMapping("/Hello-World-Bean/path-variable/{name}")
	public HelloWorldBean helloWorldPathVariable(@PathVariable String name) {

	return new HelloWorldBean(String.format("Hello World, %s",name));
	
	}

}
