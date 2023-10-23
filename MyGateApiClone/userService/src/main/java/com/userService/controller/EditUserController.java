package com.userService.controller;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.userService.model.User;
import com.userService.service.EditUserService;

@RestController
public class EditUserController {
	
	@Autowired
	private EditUserService service; 
	
	@PostMapping("/edit")
	public boolean editUser(@RequestBody User user) {
		return service.editUserService(user);
	}
}
