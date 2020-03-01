package com.brij.dao;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

import com.brij.model.Query;


public interface QueryRepository extends CrudRepository<Query,Integer> {
	
	 List<Query> findAllByDepartment(String department);
	 
	 List<Query> findAllByQueryResponse(String queryResponse);
	 
//	 doesn't work like this on Repo (can't add two variable together for crud operations in repo)
//	 List<Query> findAllByQueryResponseDepartment(String queryResponse, String department);  
	
}
