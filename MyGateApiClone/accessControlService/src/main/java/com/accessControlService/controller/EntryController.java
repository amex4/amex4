package com.accessControlService.controller;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.accessControlService.model.Entry;
import com.accessControlService.service.EntryService;

@RestController
public class EntryController {
	
	@Autowired
	private EntryService service;
	
	@PostMapping("/add/entry")
	public boolean addEntry(@RequestBody Entry entry) {
		return service.addEntry(entry);
	}
}
