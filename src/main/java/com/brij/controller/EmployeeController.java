package com.brij.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;


import com.brij.model.Employee;
import com.brij.model.Query;
import com.brij.service.EmployeeService;

@RestController
public class EmployeeController {
	@Autowired
	EmployeeService empService;
	
	@PostMapping(path="/newEmp",consumes={"application/json"}) 
	public Employee createEmployee(@RequestBody Employee emp) {
		
		return empService.createEmployee(emp.getEmpName(),emp.getEmpEmail(),emp.getEmpContact(),emp.getEmpDepartment());
	}
	
	@PostMapping(path="/updateEmp",consumes= {"application/json"}) 
	public String updateEmployee(@RequestBody Employee emp) {
		
		return empService.updateEmployee(emp.getEmpId(), emp.getEmpName(), emp.getEmpEmail(), emp.getEmpContact(), emp.getEmpDepartment());
	}
	
	@PostMapping(path="/deleteEmp",consumes= {"application/json"}) 
	public void deleteEmployee(@RequestBody Employee emp) {
		empService.deleteEmployee(emp.getEmpId());
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
