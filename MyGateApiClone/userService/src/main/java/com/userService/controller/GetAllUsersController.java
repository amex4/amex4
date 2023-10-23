package com.userService.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.userService.model.User;
import com.userService.service.GetAllUsersService;

@RestController
public class GetAllUsersController {
	
	@Autowired
	private GetAllUsersService service;
	
	@GetMapping("/user/all")
	public List<User> getAllUsers() {
		return service.getAllUsers();
	}
}
