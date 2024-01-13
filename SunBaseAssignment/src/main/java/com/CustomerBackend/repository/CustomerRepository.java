package com.CustomerBackend.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.CustomerBackend.model.CustomerDetail;

@Repository
public interface CustomerRepository extends JpaRepository<CustomerDetail, Integer>{
	
	public List<CustomerDetail> findByFirstNameContainingIgnoreCaseOrCityContainingIgnoreCaseOrEmailContainingIgnoreCase(String query1,String query2,String query3);	
	public CustomerDetail findByCustomerId(int customerId);
}
