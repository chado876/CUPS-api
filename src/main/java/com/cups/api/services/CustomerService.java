package com.cups.api.services;

import com.cups.api.repositories.ICustomerRepository;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.cups.api.entities.Customer;
import com.cups.api.entities.Customer; 

@Component
public class CustomerService { 
	
	@Autowired
	protected ICustomerRepository customerRepo; 
	
	public List<Customer> getAll(){
		return customerRepo.findAll();
	}
	
	public Customer create(Customer Customer) {
		return customerRepo.save(Customer);
	}
	
	public Customer get(int id) {
		Optional<Customer> result = customerRepo.findById(id);
		return result.isPresent() ? result.get() : null;
	}
	
	public Customer update(int id, Customer data) {
		Optional<Customer> result = customerRepo.findById(id);
		if(result.isPresent()) {
			Customer original = result.get();
			original.setFname(data.getFname());
			original.setLname(data.getLname());
			original.setId(data.getId());
			original.setImage(data.getImage());
			original.setRecording(data.getRecording());
		
			return customerRepo.save(original);
		}
		return null;
	}
	
	public boolean delete(int id) {
		Optional<Customer> result = customerRepo.findById(id);
		if(result.isPresent()) {
			Customer original = result.get();			
			 customerRepo.delete(original);
			 return true;
		}
		return false;
	}

}
