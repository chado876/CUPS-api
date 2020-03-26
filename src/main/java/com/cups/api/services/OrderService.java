package com.cups.api.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.cups.api.entities.Order;
import com.cups.api.repositories.IOrderRepository;

@Component
public class OrderService {
	
	@Autowired
	protected IOrderRepository OrderRepo;
	
	public List<Order> getAll(){
		return OrderRepo.findAll();
	}
	
	public Order create(Order Order) {
		return OrderRepo.save(Order);
	}
	
	public Order get(int id) {
		Optional<Order> result = OrderRepo.findById(id);
		return result.isPresent() ? result.get() : null;
	}
	
	public Order update(int id, Order data) {
		Optional<Order> result = OrderRepo.findById(id);
		if(result.isPresent()) {
			Order original = result.get();
			original.setId(data.getId());
			original.setCost(data.getCost());
			original.setCustomer(data.getCustomer());
			original.setItem(data.getItem());			
			return OrderRepo.save(original);
		}
		return null;
	}
	
	public boolean delete(int id) {
		Optional<Order> result = OrderRepo.findById(id);
		if(result.isPresent()) {
			Order original = result.get();			
			 OrderRepo.delete(original);
			 return true;
		}
		return false;
	}
}
