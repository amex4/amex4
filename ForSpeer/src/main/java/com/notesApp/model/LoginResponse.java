package com.notesApp.model;

public class LoginResponse {
	
	private String username;
	private String token;
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public String getToken() {
		return token;
	}
	public void setToken(String token) {
		this.token = token;
	}
	public LoginResponse(String username, String token) {
		super();
		this.username = username;
		this.token = token;
	}

}
