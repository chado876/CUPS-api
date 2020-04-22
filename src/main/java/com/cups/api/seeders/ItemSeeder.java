package com.cups.api.seeders;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.event.ContextRefreshedEvent;
import org.springframework.context.event.EventListener;
import org.springframework.data.domain.Example;
import org.springframework.stereotype.Component;

import com.cups.api.entities.Item;
import com.cups.api.repositories.IItemRepository;

@Component
public class ItemSeeder {
//	private Item[] defaultData = new Item[] {
//			new Item(1,"Americano","Beverage",8.99,10,"img.com","asl.com")	
//	};
//	@Autowired
//	protected IItemRepository itemRepo;
//	
//	@EventListener
//	public void seed(ContextRefreshedEvent event) {
//		System.out.println("-------Seeding Items-------");
//		
//		for(Item defaultItem : defaultData) {
//			Example<Item> itemExample = Example.of(defaultItem);
//			Optional<Item> itemResult = itemRepo.findOne(itemExample);
//			
//			if(itemResult.isPresent()) {
//				System.out.println("Item already in database" + defaultItem);;
//			} else {
//				System.out.println("Inserting item into database" + defaultItem);
//				itemRepo.save(defaultItem);
//			}
//			
//		}
//		
//		System.out.println("-------Completed Seeding Items-------");
//
//	}
}
