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

import com.cups.api.entities.Order;
import com.cups.api.exceptions.ResourceNotFoundException;
import com.cups.api.services.OrderService;

@CrossOrigin(origins="*",allowedHeaders="*")
@RestController
@RequestMapping("/api/orders")

public class OrderController {
		@Autowired
		protected OrderService OrderService;
	
	@GetMapping("")
	public List<Order> getAll() {
		return OrderService.getAll();
	}
	
	@GetMapping("/{id}")
	public Order get(@PathVariable("id") int id ) {
		Order data = OrderService.get(id);
		if(data==null) {
			throw new ResourceNotFoundException("Order","id",id);
		}
		
		return data;
	}
	
	@PostMapping("")
	public Order create(@Valid @RequestBody Order data) {
		return OrderService.create(data);
	}
	
	@PutMapping("/{id}")
	public Order update(
		@PathVariable("id") int id,
		@RequestBody Order data)
	{
		return OrderService.update(id, data);
	}
	
	@DeleteMapping("/{id}")
	public ResponseEntity<?>delete(@PathVariable("id") int id){
		OrderService.delete(id);
		if(OrderService.delete(id))
			return ResponseEntity.ok(true);
		else
			return ResponseEntity.status(400).body(false);

	}
}
