package com.cups.api.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.cups.api.entities.Item;
import com.cups.api.repositories.IItemRepository;

@Component
public class ItemService {
	
	@Autowired
	protected IItemRepository ItemRepo;
	
	public List<Item> getAll(){
		return ItemRepo.findAll();
	}
	
	public Item create(Item item) {
		return ItemRepo.save(item);
	}
	
	public Item get(int id) {
		Optional<Item> result = ItemRepo.findById(id);
		return result.isPresent() ? result.get() : null;
	}
	
	public Item getbyName(String name) {
		Item item = new Item(); 
		item.setName(name); 
		Optional<Item> result = ItemRepo.findByName(name);
		return result.isPresent() ? result.get() : null;
	}
	
//	public List<Item> getbyCategory(String category) {
//		Item item = new Item(); 
//		item.setCategory(category); 
//		List<Optional<Item>> result = ItemRepo.findByCategory(category);
//		return result.isPresent() ? result.get() : null;
//	}
	public Item update(int id, Item data) {
		Optional<Item> result = ItemRepo.findById(id);
		if(result.isPresent()) {
			Item original = result.get();
			original.setName(data.getName());
			original.setCategory(data.getCategory());
			original.setCost(data.getCost());
			original.setStock(data.getStock());
			original.setUrl(data.getUrl());
			original.setAsl(data.getAsl());
			
			return ItemRepo.save(original);
		}
		return null;
	}
	
	public boolean delete(int id) {
		Optional<Item> result = ItemRepo.findById(id);
		if(result.isPresent()) {
			Item original = result.get();			
			 ItemRepo.delete(original);
			 return true;
		}
		return false;
	}
}
