package com.accessControlService.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.accessControlService.model.Entry;

public interface EntryRepository extends JpaRepository<Entry, Integer>{

	public Entry findByEntryId(int entryId);
}
