package com.userService.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.userService.model.User;
import com.userService.service.UserRegistrationService;

@RestController
public class UserRegistrationController {
	
	@Autowired
	private UserRegistrationService service;
	
	@PostMapping("/registration")
	public boolean registerUser(@RequestBody User user) {
		return service.registerUser(user);
	}

}
