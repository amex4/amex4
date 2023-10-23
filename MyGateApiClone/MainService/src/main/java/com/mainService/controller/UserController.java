package com.mainService.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.reactive.function.client.WebClient;

import com.mainService.model.Entry;
import com.mainService.model.User;

import reactor.core.publisher.Mono;

@RestController
public class UserController {
	
	@Autowired
	private WebClient.Builder webClientBuilder;
	
	@GetMapping("user/{username}/details")
	public User getDetails(@PathVariable String username) {
		return webClientBuilder.build()
				.get()
				.uri("http://localhost:8000//user/details/"+username)
				.retrieve()
				.bodyToMono(User.class)
				.block();
				
	}
	
	@GetMapping("user/{entryId}/details")
	public Entry getRecentEntry(@PathVariable int entryId) {
		
		return webClientBuilder.build()
				.get()
				.uri("http://localhost:8001/get/"+entryId)
				.retrieve()
				.bodyToMono(Entry.class)
				.block();
		
	}
	
	@PostMapping("user/allow")
	public Boolean allowEntry(@RequestBody Entry entry) {
		return webClientBuilder.build()
				.post()
				.uri("http://localhost:8001/allow")
				.body(Mono.just(entry),Entry.class)
				.retrieve()
				.bodyToMono(Boolean.class)
				.block();
	}
	
}

