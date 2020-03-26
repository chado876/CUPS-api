package com.cups.api.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.cups.api.entities.Customer;

public interface ICustomerRepository 
extends JpaRepository<Customer,Integer>
{

}
