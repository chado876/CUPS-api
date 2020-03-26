package com.cups.api.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.cups.api.entities.Order;

public interface IOrderRepository extends JpaRepository<Order,Integer>{
	
}
