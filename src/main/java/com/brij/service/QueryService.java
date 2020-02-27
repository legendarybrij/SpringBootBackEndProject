package com.brij.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestBody;

import com.brij.dao.QueryRepository;
import com.brij.model.Customer;
import com.brij.model.Query;

@Service
public class QueryService {
	@Autowired
	QueryRepository qRepo;
	
	public Query createQuery(Query q){
		qRepo.save(q);
		return q;
	}
	
	public Query updateQuery(Query q){
		Query oldQ= findQueryById(q.getQueryId());
		oldQ = q;
		qRepo.save(oldQ);
		return oldQ;
	}
	
	public void deleteQuery(int id) {
		qRepo.deleteById(id);
	}
	
	public Query findQueryById(int id) {
		return qRepo.findById(id).get();
	}
		
	public List<Query> findQueriesByDept(String dept){
		
		return qRepo.findAllByDepartment(dept);		
	}
	
	public List<Query> findAllQueries() {
		return (List<Query>) qRepo.findAll();
	}
	
}
