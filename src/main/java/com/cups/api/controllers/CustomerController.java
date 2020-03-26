package com.cups.api.controllers;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.cups.api.entities.Customer;
import com.cups.api.entities.Customer;
import com.cups.api.exceptions.ResourceNotFoundException;
import com.cups.api.services.CustomerService;
import com.cups.api.services.CustomerService;

@CrossOrigin(origins="*",allowedHeaders="*")
@RestController 
@RequestMapping("/api/customers")



public class CustomerController {

@Autowired
protected CustomerService customerService;  

@GetMapping("")
public List<Customer> getAll() {
return customerService.getAll();
}

@GetMapping("/{id}")
public Customer get(@PathVariable("id") int id ) {
Customer data = customerService.get(id);
if(data==null) {
	throw new ResourceNotFoundException("Customer","id",id);
}

return data;
}

@PostMapping("")
public Customer create(@Valid @RequestBody Customer data) {
return customerService.create(data);
}

@PutMapping("/{id}")
public Customer update(
@PathVariable("id") int id,
@RequestBody Customer data)
{
return customerService.update(id, data);
}

@DeleteMapping("/{id}")
public ResponseEntity<?>delete(@PathVariable("id") int id){
customerService.delete(id);
if(customerService.delete(id))
	return ResponseEntity.ok(true);
else
	return ResponseEntity.status(400).body(false);

}

}
