package com.brij.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.brij.model.Query;
import com.brij.service.QueryService;

@RestController
public class QueryController {

	@Autowired
	QueryService qService;
	
	@PostMapping(path="/newQuery")
	public Query createQuery(@RequestBody Query q){
		
		return qService.createQuery(q);
	}
	
	@PostMapping(path="/updateQuery")
	public Query updateQuery(@RequestBody Query q){
		
		return qService.updateQuery(q);
	}
	
	@PostMapping(path="/deleteQuery/{id}")
	public String deleteQuery(@PathVariable("id") int id) {
		qService.deleteQuery(id);
		return "Deleted";
	}
	
	@GetMapping(path="/findQueryById")
	public Query findQueryById(@RequestBody Query q) {
		return qService.findQueryById(q.getQueryId());
	}
	
	@GetMapping(path="/findQueriesByDept")
	public List<Query> findQueriesByDept(@RequestBody Query q){
		
		return qService.findQueriesByDept(q.getDepartment());
		
	}
	
	@GetMapping(path="/findAllQueries")
	public List<Query> findAllQueries() {
		return qService.findAllQueries();
	}
	
	@GetMapping(path="/findAllNullResponseQueriesByDept")
	public List<Query> findAllNullResponseQueriesByDept(@RequestBody Query q) {
		
		return (List<Query>) qService.findAllNullResponseQueriesByDept(q.getDepartment());
	}
	
	
	
	@GetMapping(path="/findAllNullResponseQueries")
	public List<Query> findAllNullResponseQueries() {
		return (List<Query>) qService.findAllNullResponseQueries();
	}

}
