package com.userService.controller;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import com.userService.model.User;
import com.userService.service.GetUserService;

@RestController
public class GetUserController {
	
	@Autowired
	private GetUserService service;
	
	@GetMapping("/user/details/{username}")
	public User getUser(@PathVariable String username) {
		return service.getUser(username);
	}
	
	
	@GetMapping("user/{houseNumber}")
	public User getUserByFlat(@PathVariable String houseNumber) {
		return service.getUserByFlat(houseNumber);
	}

}
