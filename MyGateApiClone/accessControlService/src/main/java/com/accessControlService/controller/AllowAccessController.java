package com.accessControlService.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.accessControlService.model.Entry;
import com.accessControlService.service.AllowAccessService;

@RestController
public class AllowAccessController {
	
	@Autowired
	private AllowAccessService service; 
	
	@PostMapping("/allow")
	public boolean allowAccess(@RequestBody Entry entry) {
		return service.allowAccess(entry.getEntryId());
	}
	
}
