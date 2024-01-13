package com.notesApp.controller;

import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.notesApp.model.Notes;
import com.notesApp.service.NotesService;
import com.notesApp.util.JwtUtil;

import io.jsonwebtoken.Claims;
import jakarta.servlet.http.HttpServletRequest;

@RestController
public class NotesController {
	
	@Autowired
	private NotesService notesService;
	
	@Autowired
	private JwtUtil jwtUtil;
	
	@GetMapping("api/home")
	public String home() {
		return "Welcome to notes home";
	}
	
	
	@PostMapping("/api/notes")
	public Map<String, Object> createNote(@RequestBody Notes note, HttpServletRequest request) {
		
		Map<String, Object> response = new HashMap<>();
		Claims claims =   jwtUtil.resolveClaims(request);
		String username = jwtUtil.getUsername(claims);
		response.put("success", notesService.createNote(note,username));
		response.put("data", note);
		
		return response;
		 
	}
	
	@GetMapping("/api/notes")
	public Map<String, Object> getNotes(HttpServletRequest request) {
		Map<String, Object> response = new HashMap<>();
		Claims claims =   jwtUtil.resolveClaims(request);
		String username = jwtUtil.getUsername(claims);
		response.put("data", notesService.getAllNotes(username));
		
		return response;
	}
	
	@GetMapping("/api/notes/{id}")
	public Map<String, Object> getSingleNote(@PathVariable int id,HttpServletRequest request){
		Map<String, Object> response = new HashMap<>();
		Claims claims =   jwtUtil.resolveClaims(request);
		String username = jwtUtil.getUsername(claims);
		response.put("data", notesService.getSingleNote(username, id));
		
		return response;
	}
	
	@PutMapping("/api/notes/{id}")
	public Map<String, Object> updateSingleNote(@PathVariable int id,@RequestBody Notes note ,HttpServletRequest request){
		Map<String, Object> response = new HashMap<>();
		Claims claims =   jwtUtil.resolveClaims(request);
		String username = jwtUtil.getUsername(claims);
		response.put("success", notesService.updateNote(username, id, note));
		return response;
	}
	
	
	

}
