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
	
	public boolean create(CustomerDetail customerDetail) {
		try {
			customerRepository.save(customerDetail);
			return true;
		} catch (Exception e) {
			return false;
		}
	}
	
	public CustomerDetail getCustomer(int id) {
		return customerRepository.findByCustomerId(id);
	}
	
	public List<CustomerDetail> getAllCustomers(String query) {
		if (query.equals("")) {
			return customerRepository.findAll();
		}
		return customerRepository.findByFirstNameContainingIgnoreCaseOrCityContainingIgnoreCaseOrEmailContainingIgnoreCase(query, query, query);
	}
	
	public boolean update(CustomerDetail customerDetail) {
		try {
			customerRepository.save(customerDetail);
			return true;
		} catch (Exception e) {
			return false;
		}
	}
	
	public boolean delete(int id) {
		try {
			customerRepository.deleteById(id);
			return true;
		} catch (Exception e) {
			return false;
		}
	}
	
}
