package com.brij.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.brij.model.Customer;
import com.brij.service.CustomerService;

@CrossOrigin(origins="http://localhost:4200")
@RestController
public class CustomerController {
	@Autowired
	CustomerService cusService;
	
	@PostMapping(path="/newCus",consumes={"application/json"}) 
	public Customer createCustomer(@RequestBody Customer customer) {
		return cusService.createCustomer(customer);
	}
	
	@PostMapping(path="/updateCus",consumes={"application/json"}) 
	public Customer updateCustomer(@RequestBody Customer customer) {
		
		return cusService.updateCustomer(customer);
	}
	
	@DeleteMapping(path="/deleteCus/{id}") 
	public void deleteCustomer(@PathVariable("id") int id) {
		cusService.deleteCustomer(id);
	}
	
//	@GetMapping(path="/deleteAllCustomers")
//	public void DeleteAllCustomers() {
//		 cusService.deleteAllCustomers();
//	}
	
	@GetMapping(path="/findCusById",consumes= {"application/json"})
	public Customer findCusById(@RequestBody Customer customer) {
		return cusService.findCusById(customer.getCusId());
	}
	
	@GetMapping(path="/findAllCustomers", produces = "application/json")
	public List<Customer> findAllCustomers() {
		return cusService.findAllCustomers();
	}
	
	@GetMapping(path="/findCusIdByCusUsername/{username}")
	public Integer findCusIdByCusUsername(@PathVariable("username") String username) {		
		return cusService.findCusIdByCusUsername(username);
	}

}
