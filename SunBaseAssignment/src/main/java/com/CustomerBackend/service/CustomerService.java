package com.CustomerBackend.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.CustomerBackend.model.CustomerDetail;
import com.CustomerBackend.repository.CustomerRepository;

@Service
public class CustomerService {
	
	@Autowired
	private CustomerRepository customerRepository;
	
	// save the customer detail fetched from api to the database
	
	public boolean create(CustomerDetail customerDetail) {
		try {
			customerRepository.save(customerDetail);
			return true;
		} catch (Exception e) {
			return false;
		}
	}
	
	// find the customer from database by id
	
	public CustomerDetail getCustomer(int id) {
		return customerRepository.findByCustomerId(id);
	}
	
	// get all customers from database
	
	public List<CustomerDetail> getAllCustomers(String query) {
		if (query.equals("")) {
			return customerRepository.findAll();
		}
		return customerRepository.findByFirstNameContainingIgnoreCaseOrCityContainingIgnoreCaseOrEmailContainingIgnoreCase(query, query, query);
	}
	
	// update the customer in database
	
	public boolean update(CustomerDetail customerDetail) {
		try {
			customerRepository.save(customerDetail);
			return true;
		} catch (Exception e) {
			return false;
		}
	}
	
	//delete the customer from database
	
	public boolean delete(int id) {
		try {
			customerRepository.deleteById(id);
			return true;
		} catch (Exception e) {
			return false;
		}
	}
	
}
