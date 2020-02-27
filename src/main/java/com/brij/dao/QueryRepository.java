package com.brij.dao;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

import com.brij.model.Query;


public interface QueryRepository extends CrudRepository<Query,Integer> {
	
	 List<Query> findAllByDepartment(String department);
	
}
