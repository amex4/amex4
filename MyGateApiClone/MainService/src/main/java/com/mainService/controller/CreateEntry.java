package com.mainService.controller;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.reactive.function.client.WebClient;

import com.mainService.model.Entry;
import com.mainService.model.User;

import reactor.core.publisher.Mono;

@RestController
public class CreateEntry {
	
	@Autowired
	private WebClient.Builder webClientBuilder;
	
	
	
	@PostMapping("/create/entry")
	public Map<String, Object> createEntry(@RequestBody Entry entry) {
		Map<String, Object> map = new HashMap<>();
		boolean flag = webClientBuilder.build()
							.post()
							.uri("http://localhost:8001/add/entry")
							.body(Mono.just(entry),Entry.class)
							.retrieve()
							.bodyToMono(Boolean.class)
							.block();
		
		
		List<User> users = new ArrayList<>();
		
		if(flag)
		{
			for (String houseNumber : entry.getHouseNumbers()) {
				users.add(webClientBuilder.build()
						.get()
						.uri("http://localhost:8000/user/"+houseNumber)
						.retrieve()
						.bodyToMono(User.class)
						.block()
						);
			}
			
			for (User user : users) {
				webClientBuilder.build()
				.post()
				.uri("http://localhost:8000/set/entry/"+entry.getEntryId())
				.body(Mono.just(user),User.class)
				.retrieve()
				.bodyToMono(Boolean.class)
				.block();
				
				

			}
		}
		
		map.put("success", flag);
		map.put("data", entry );
		return map;
	}
	
}
