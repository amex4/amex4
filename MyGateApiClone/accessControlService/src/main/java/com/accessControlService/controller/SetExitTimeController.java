package com.accessControlService.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.accessControlService.service.SetExitTimeService;

@RestController
public class SetExitTimeController {
	
	@Autowired
	private SetExitTimeService service;
	
	@PostMapping("time/exit")
	public boolean setExitTime(@RequestParam int entryId,@RequestParam String time) {
		return service.setExitTime(entryId, time);
	}
	
}
