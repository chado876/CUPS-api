package com.cups.api.repositories;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.cups.api.entities.Item;

public interface IItemRepository extends JpaRepository<Item,Integer>{
	
	public Optional<Item> findByName(String itemName);
	public Optional<Item> findByCategory(String itemCategory);
	
} 


