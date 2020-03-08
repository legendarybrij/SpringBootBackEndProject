package com.brij;


import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import java.util.stream.Collectors;
import java.util.stream.Stream;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mockito;
import org.mockito.stubbing.OngoingStubbing;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import com.brij.dao.CustomerRepository;
import com.brij.model.Customer;
import com.brij.service.CustomerService;

@RunWith(SpringRunner.class)
@SpringBootTest
public class SpringBootProjectApplicationTests {

	@Autowired
	private CustomerService service;
//	= (CustomerService) Mockito.mock(CustomerService.class);
//	@MockBean
	private CustomerRepository repository = (CustomerRepository) Mockito.mock(CustomerRepository.class);
	private int id=1;
	
	
//	@Test
//	public void deleteCustomerTest() {
//		Customer cus1 = new Customer(id,"Neil","neil@gmail.com","9125647654","308 Main st");
//		service.createCustomer(cus1);
////		when(service.deleteCustomer(id)).thenReturn(null);
//
//		service.deleteCustomer(id);
//		verify(repository, times(1)).deleteById(id);
//		//assertEquals(null, service.findCusById(id).toString());
//		
//	}
	

	@Test
	public void createCustomerTest() {
		//this.id=service.findAllCustomers().size()+1;
//		System.out.println(service.findAllCustomers().size()+1);
		Customer cus = new Customer(id,"Neil","neil@gmail.com","9125647654","308 Main st","neil");	
		when(repository.save(cus)).thenReturn(cus);
		assertEquals(cus.toString(), service.createCustomer(cus).toString());
		
	}
	
	@Test
	public void updateCustomerTest() {
		Customer cus = new Customer(id,"Neil","neil@gmail.com","9125647654","308 Main st","neilshah");		
		when(repository.save(cus)).thenReturn(cus);
		assertEquals(cus.toString(), service.updateCustomer(cus).toString());
		
	}
	
	
	@Test
	public void findByIdCustomerTest() {
		Customer cus = new Customer(id,"Neil","neil@gmail.com","9125647654","308 Main st","neilshah");
		when(repository.findById(id)).thenReturn(cus);
		//service.updateCustomer(cus);
		assertEquals(cus.toString(), service.findCusById(id).toString());
		
	}
	
//	@Test
//	public void findAllCustomerTest() {
//		Customer cus1 = new Customer(1, "Honglin", "Honglin@gmail.com", "4125646564","208 main st");
//		Customer cus2 = new Customer(2, "Shekinah", "shekina@hotmail.com", "4126748657","208 main st");
//		when(repository.findAll()).thenReturn(Stream
//				.of(cus1, cus2).collect(Collectors.toList()));
////		service.createCustomer(cus1);
////		service.createCustomer(cus2);
//		assertEquals(2, service.findAllCustomers().size());
//		
//	}
	
	
	

	
	

}
