package com.brij.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.brij.dao.EmployeeRepository;
import com.brij.model.Customer;
import com.brij.model.Employee;


@Service
public class EmployeeService {
	@Autowired
	EmployeeRepository empRepo;
	public Employee createEmployee(Employee emp) {
	
//		Employee emp = new Employee() 
//		emp.setEmpName(empName);
//		emp.setEmpEmail(empEmail);
//		emp.setEmpContact(empContact);
//		emp.setEmpDepartment(empDepartment);
		return empRepo.save(emp);
	}
	
	public Employee updateEmployee(Employee emp) {
//		Employee emp = findEmpById(empId);
//		emp.setEmpName(empName);
//		emp.setEmpEmail(empEmail);
//		emp.setEmpContact(empContact);
//		emp.setEmpDepartment(empDepartment);
		return empRepo.save(emp);
	}
	
	public void deleteEmployee(int empId) {
		empRepo.deleteById(empId);
	}
	
	public Employee findEmpById(int empId) {
		Employee emp = empRepo.findById(empId).get();
		
		return emp;
	}
	
	public List<Employee> findAllEmployees() {
		return (List<Employee>) empRepo.findAll();
	}
	

}