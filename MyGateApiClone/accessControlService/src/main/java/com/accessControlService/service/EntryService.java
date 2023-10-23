package com.accessControlService.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.accessControlService.dao.EntryRepository;
import com.accessControlService.model.Entry;

@Component
public class EntryService {
	
	@Autowired
	private EntryRepository repository;
	
	public boolean addEntry(Entry entry) {
		if(!repository.existsById(entry.getEntryId())) {
			repository.save(entry);
			return true;
		}
		else {
			return false;
		}
		
	}
}
