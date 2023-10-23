package com.accessControlService.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.accessControlService.dao.EntryRepository;
import com.accessControlService.model.Entry;

@Component
public class AllowAccessService {
	
	@Autowired
	private EntryRepository repository;
	
	public boolean allowAccess(int entryId) {
		Entry entry = repository.findByEntryId(entryId);
		
		if (entry.isAccessAllowed()) {
			return false;
		}
		entry.setAccessAllowed(true);
		repository.save(entry);
		return true;
	}
	
}
