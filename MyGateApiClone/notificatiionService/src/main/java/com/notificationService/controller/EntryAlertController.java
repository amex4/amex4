package com.notificationService.controller;

import java.util.HashMap;
import java.util.Map;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class EntryAlertController {
	
	
	@GetMapping("/alert/{username}")
	public Map<String, String> entryAlert(@PathVariable String username) {
		Map<String, String> map = new HashMap<>();
		map.put("msg","there is new entry for you "+username);
		return map;
	}
}
