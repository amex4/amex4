package com.userService.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.userService.model.User;
import com.userService.service.CurrentEntryService;

@RestController
public class CurrentEntryController {
	
	@Autowired
	private CurrentEntryService service;
	
	@PostMapping("set/entry/{entryId}")
	public boolean setEntryId(@PathVariable int entryId,@RequestBody User user) {
		return service.setEntryId(user, entryId);
	}
	
}
