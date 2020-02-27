package com.brij.dao;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.brij.model.Employee;

public interface EmployeeRepository extends CrudRepository<Employee,Integer>  {

}
