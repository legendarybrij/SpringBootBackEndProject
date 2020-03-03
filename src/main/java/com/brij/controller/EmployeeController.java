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

import com.brij.model.Employee;
import com.brij.service.EmployeeService;

@CrossOrigin(origins="http://localhost:4200")
@RestController
public class EmployeeController {
	@Autowired
	EmployeeService empService;
	
	@PostMapping(path="/newEmp") 
	public Employee createEmployee(@RequestBody Employee emp) {
		
		return empService.createEmployee(emp);
	}
	
	@PostMapping(path="/updateEmp") 
	public Employee updateEmployee(@RequestBody Employee emp) {
		
		return empService.updateEmployee(emp);
	}
	
	@DeleteMapping(path="/deleteEmp/{id}") 
	public void deleteEmployee(@PathVariable("id") int id) {
		empService.deleteEmployee(id);
	}
	
	@GetMapping(path="/findEmpById",consumes= {"application/json"})
	public Employee findEmpById(@RequestBody Employee emp) {		
		return empService.findEmpById(emp.getEmpId());
	}
	
	@GetMapping(path="/findAllEmployees")
	public List<Employee> findAllEmployees() {
		return empService.findAllEmployees();
	}
	
}
