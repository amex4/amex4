package com.notesApp.service;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.notesApp.model.Notes;
import com.notesApp.repository.NotesRepository;
import com.notesApp.repository.UserRepository;

@Service
public class NotesService {
	
	@Autowired
	private NotesRepository notesRepository;
	
	@Autowired
	private UserRepository userRepository;
	
	public boolean createNote(Notes notes,String username) {
		try {
			notes.setUser(userRepository.findByUsername(username));
			notesRepository.save(notes);
			return true;
		} catch (Exception e) {
			return false;
		}
	}
	
	public Object getAllNotes(String username){
		try {
			return notesRepository.findByUser(userRepository.findByUsername(username));
		} catch (Exception e) {
			return "cannot fetch data at this time : "+e;
		}
	}
	
	public Object getSingleNote(String username,int id) {
		try {
			return notesRepository.findByUserAndNoteId(userRepository.findByUsername(username), id);
		} catch (Exception e) {
			return "cannot fetch data at this time : "+e;
		}
	}
	
	public boolean updateNote(String username, int id,Notes notes) {
		try {
			Notes updatedNote = notesRepository.findByUserAndNoteId(userRepository.findByUsername(username), id);
			updatedNote.setNoteBody(notes.getNoteBody());
			notesRepository.save(notes);
			return true;
		} catch (Exception e) {
			return false;
		}
	}
	
	
}
