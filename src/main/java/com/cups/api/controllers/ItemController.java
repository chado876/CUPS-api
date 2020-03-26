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

import com.cups.api.entities.Item;
import com.cups.api.exceptions.ResourceNotFoundException;
import com.cups.api.services.ItemService;

@CrossOrigin(origins="*",allowedHeaders="*")
@RestController
@RequestMapping("/api/items")

public class ItemController {
		@Autowired
		protected ItemService itemService;
	
	@GetMapping("")
	public List<Item> getAll() {
		return itemService.getAll();
	}
	
	@GetMapping("/{id}")
	public Item get(@PathVariable("id") int id ) {
		Item data = itemService.get(id);
		if(data==null) {
			throw new ResourceNotFoundException("Item","id",id);
		}
		
		return data;
	}
	
	@PostMapping("")
	public Item create(@Valid @RequestBody Item data) {
		return itemService.create(data);
	}
	
	@PutMapping("/{id}")
	public Item update(
		@PathVariable("id") int id,
		@RequestBody Item data)
	{
		return itemService.update(id, data);
	}
	
	@DeleteMapping("/{id}")
	public ResponseEntity<?>delete(@PathVariable("id") int id){
		itemService.delete(id);
		if(itemService.delete(id))
			return ResponseEntity.ok(true);
		else
			return ResponseEntity.status(400).body(false);

	}
}
