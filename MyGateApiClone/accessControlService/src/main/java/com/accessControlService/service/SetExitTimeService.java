package com.accessControlService.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.accessControlService.dao.EntryRepository;
import com.accessControlService.model.Entry;

@Component
public class SetExitTimeService {
	
	@Autowired
	private EntryRepository repository;
	
	public boolean setExitTime(int entryId, String exitTime) {
		try {
		Entry entry = repository.findByEntryId(entryId);
		entry.setExitTime(exitTime);
		repository.save(entry);
		return true;
		}
		catch (Exception e) {
			return false;
		}
	}
}
