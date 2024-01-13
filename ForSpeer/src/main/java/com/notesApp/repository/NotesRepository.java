package com.notesApp.repository;



import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.notesApp.model.Notes;
import com.notesApp.model.UserDetails;

public interface NotesRepository extends JpaRepository<Notes, Integer>{
	
	List<Notes> findByUser(UserDetails user);
	Notes findByUserAndNoteId(UserDetails user,int id);
}
