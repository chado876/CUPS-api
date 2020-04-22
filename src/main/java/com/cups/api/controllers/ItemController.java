package com.cups.api.controllers;

import java.util.List;
import java.util.Optional;

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
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
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
	
	@GetMapping("/byName{name}")
	public Item get(@PathVariable("name") String name ) {
		Item data = itemService.getbyName(name);
		if(data==null) {
			throw new ResourceNotFoundException("Item","name",name);
		}
		
		return data;
	} 
	
//	@GetMapping("/byCategory{category}")
//	public Item get(@PathVariable("category") String category ) {
//		Item data = itemService.getbyCategory(category);
//		if(data==null) {
//			throw new ResourceNotFoundException("Item","category",category);
//		}
//		
//		return data;
//	} 
//	
//	@GetMapping("/byCategory{category}")
//	public Item get(@PathVariable("category") String category ) {
//		List<Item> data = itemService.getAll();
//		List<Item> filtered_data = null;
//
//		if(data==null) {
//			throw new ResourceNotFoundException("Item","category",category);
//		} else {
//			int n=0;
//			while(data.isEmpty() == false) {
//				if (category.contentEquals("Beverage")){
//					if(data.get(n).getCategory().contentEquals("Beverage")) {
//							filtered_data.add(data.get(n));
//					}
//						n++;
//			}
//			}
//			
//		}
		
//		return (Item) filtered_data;
//	} 
	
	@PostMapping("")
	public Item create(@Valid @RequestBody Item data) { 
		Item duplicate = itemService.getbyName(data.getName());
		if(duplicate==null) {
		return itemService.create(data);
		} 
		return null;
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
