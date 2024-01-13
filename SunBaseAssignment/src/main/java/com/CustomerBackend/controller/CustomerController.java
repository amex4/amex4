package com.CustomerBackend.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.CustomerBackend.model.CustomerDetail;
import com.CustomerBackend.service.CustomerService;
import com.CustomerBackend.util.JwtUtil;

import io.jsonwebtoken.Claims;
import jakarta.servlet.http.HttpServletRequest;

@CrossOrigin(origins = "http://localhost:3000/")
@RestController
public class CustomerController {
	
	@Autowired
	private CustomerService customerService;
	
	@Autowired
	private JwtUtil jwtutil;
	
	@PostMapping("/customer/create")
	public ResponseEntity<Object> createCustomer(@RequestBody CustomerDetail customer,HttpServletRequest request) {
		Claims claims = jwtutil.resolveClaims(request);
		String email = jwtutil.getEmail(claims);
		customer.setEmail(email);
		try {
			if(customerService.create(customer)) {
				return ResponseEntity.ok(customer);
			}
			else {
				throw new Exception();
			}
		} catch (Exception e) {
			return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(e.getMessage());
		}
	}
	
	@GetMapping("/customer/all")
	public ResponseEntity<Object> getAllCustomers(@RequestParam(defaultValue = "") String query) {
		try {
			List<CustomerDetail> result = customerService.getAllCustomers(query);
			return ResponseEntity.ok(result);
		}
		catch (Exception e) {
			return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(e.getMessage());
		}
	}
	
	@GetMapping("/customer/{id}")
	public ResponseEntity<Object> getCustomer(@PathVariable int id){
		try {
			CustomerDetail customer = customerService.getCustomer(id);
			return ResponseEntity.ok(customer);
		} catch (Exception e) {
			return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(e.getMessage());
		}
	}
	
	@PutMapping("/customer/{id}")
	public ResponseEntity<Object> updateCustomer(@PathVariable int id,@RequestBody CustomerDetail customer,HttpServletRequest request){
		customer.setCustomerId(id);
		Claims claims = jwtutil.resolveClaims(request);
		String email = jwtutil.getEmail(claims);
		customer.setEmail(email);
		try {
			if (customerService.update(customer)) {
				return ResponseEntity.ok(customer);
			}
			else {
				throw new Exception();
			}
		} catch (Exception e) {
			return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(e.getMessage());
		}
	}
	
	@DeleteMapping("/customer/{id}")
	public ResponseEntity<Object> delteCustomer(@PathVariable int id){
		try {
			if (customerService.delete(id)) {
				return ResponseEntity.ok("success");
			}
			else {
				throw new Exception();
			}
		} catch (Exception e) {
			return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(e.getMessage());
		}
	}
	
	
	
	
	
}
