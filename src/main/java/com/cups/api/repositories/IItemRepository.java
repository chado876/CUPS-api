package com.cups.api.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.cups.api.entities.Item;

public interface IItemRepository extends JpaRepository<Item,Integer>{
	
}
