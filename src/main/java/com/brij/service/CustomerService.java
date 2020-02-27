package com.brij.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.brij.dao.CustomerRepository;
import com.brij.model.Customer;
import com.brij.model.Rating;
@Service
public class CustomerService {
	@Autowired
	CustomerRepository custRepo;
	public Customer createCustomer(Customer cus) {
	
//		Customer cus = new Customer();
//		cus.setCusName(cusName);
//		cus.setCusEmail(cusEmail);
//		cus.setCusContact(cusContact);
//		cus.setCusAddress(cusAddress);
		return custRepo.save(cus);
	}
	
	public Customer updateCustomer(Customer cus) {
//		Customer cus = findCusById(cusId);
//		cus.setCusName(cusName);
//		cus.setCusEmail(cusEmail);
//		cus.setCusContact(cusContact);
//		cus.setCusAddress(cusAddress);
		
		return custRepo.save(cus);
	}
	
	public void deleteCustomer(int cusId) {
		custRepo.deleteById(cusId);
	}
	
//	public void deleteAllCustomers() {
//		custRepo.deleteAll();
//	}
	
	public Customer findCusById(int cusId) {
		Customer cus = custRepo.findById(cusId);
		
		return cus;
	}
	
	public List<Customer> findAllCustomers() {
		
		return (List<Customer>) custRepo.findAll();
	}
	
	
	

}
