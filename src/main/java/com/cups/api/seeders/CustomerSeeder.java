package com.cups.api.seeders;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.event.ContextRefreshedEvent;
import org.springframework.context.event.EventListener;
import org.springframework.data.domain.Example;
import org.springframework.stereotype.Component;

import com.cups.api.entities.Customer;

import com.cups.api.repositories.ICustomerRepository;


@Component
public class CustomerSeeder {
	
	private Customer[] defaultData = new Customer[] {
			new Customer(1,"password", "John", "Doe", "rec.mp3","image.jpg",500.00)
			
	};
	
	@Autowired
	protected ICustomerRepository customerRepo;
      
	@EventListener
	public void seed(ContextRefreshedEvent event) {
		
		System.out.println("-------------Seeding Customer--------");
		
		
		for(Customer defaultCustomer : defaultData ) {
			
			Example<Customer> customerExample = Example.of(defaultCustomer);
			Optional<Customer> customerResult = customerRepo.findOne(customerExample);
			
			if(customerResult.isPresent()) {
				System.out.println("Customer already in database" + defaultCustomer);;
			} else {
				System.out.println("Inserting customer into database" + defaultCustomer);
				customerRepo.save(defaultCustomer);
			}
		}
		
		System.out.println("-------------Seeding Completed--------");
	}
}
