package com.accessControlService.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.accessControlService.dao.EntryRepository;
import com.accessControlService.model.Entry;

@Component
public class GetEntryService {

	@Autowired
	private EntryRepository  repository;
	
	
	public Entry getSingleEntry(int entryId) {
		try {
		return repository.findByEntryId(entryId);
		}
		catch (Exception e) {
			// TODO: handle exception
			return null;
		}
		
	}
	
	public List<Entry> getAllEntries(){
		try {
			return repository.findAll();
		}
		catch(Exception e){
			return null;
		}
	}
}
