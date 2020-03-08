package com.brij.dao;


import org.springframework.data.repository.CrudRepository;

import com.brij.model.Customer;


public interface CustomerRepository extends CrudRepository<Customer,Integer>  {
	
	Customer findById(int id);
	
	Customer findByCusUsername(String username);

}
