package com.cups.api.seeders;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.event.ContextRefreshedEvent;
import org.springframework.context.event.EventListener;
import org.springframework.data.domain.Example;
import org.springframework.stereotype.Component;

import com.cups.api.entities.Customer;
import com.cups.api.entities.Item;
import com.cups.api.entities.Order;
import com.cups.api.repositories.IOrderRepository;

@Component
public class OrderSeeder {
	
//	Customer customer = new Customer();
//	Item item = new Item();
//	
//	private Order[] defaultData = new Order[] {
//			new Order(1,item.getCost(),customer,item)	
//	};
//	@Autowired
//	protected IOrderRepository OrderRepo;
//	
//	@EventListener
//	public void seed(ContextRefreshedEvent event) {
//		System.out.println("-------Seeding Orders-------");
//		
//		for(Order defaultOrder : defaultData) {
//			Example<Order> OrderExample = Example.of(defaultOrder);
//			Optional<Order> OrderResult = OrderRepo.findOne(OrderExample);
//			
//			if(OrderResult.isPresent()) {
//				System.out.println("Order already in database" + defaultOrder);;
//			} else {
//				System.out.println("Inserting Order into database" + defaultOrder);
//				OrderRepo.save(defaultOrder);
//			}
//			
//		}
//		
//		System.out.println("-------Completed Seeding Orders-------");
//
//	}
}
