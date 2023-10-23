package com.accessControlService.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import com.accessControlService.model.Entry;
import com.accessControlService.service.GetEntryService;

@RestController
public class GetEntryController {
	
	@Autowired
	private GetEntryService service;
	
	@GetMapping("/get/{entryId}")
	public Entry getSingleEntry(@PathVariable int entryId) {
		return service.getSingleEntry(entryId);
	}
	
	@GetMapping("/all/entry")
	public List<Entry> getAllEntries() {
		return service.getAllEntries();
	}
	
}
