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

import com.brij.model.Query;
import com.brij.service.QueryService;

@CrossOrigin(origins="http://localhost:4200")
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
	
	@DeleteMapping(path="/deleteQuery/{id}")
	public void deleteQuery(@PathVariable("id") int id) {
		
		qService.deleteQuery(id);
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
	
	@GetMapping(path="/findAllNullResponseQueriesByCusId/{cusId}")
	public List<Query> findAllNullResponseQueriesByCusId(@PathVariable("cusId")int cusId) {
		return qService.findAllNullResponseQueriesByCusId(cusId);
	}
	
	@GetMapping(path="/findAllResponseQueriesByCusId/{cusId}")
	public List<Query> findAllResponseQueriesByCusId(@PathVariable("cusId")int cusId) {
		return qService.findAllResponseQueriesByCusId(cusId);
	}
	
	@GetMapping(path="/findAllNullResponseQueriesByDept/{dept}")
	public List<Query> findAllNullResponseQueriesByDept(@PathVariable("dept") String dept) {
		
		return (List<Query>) qService.findAllNullResponseQueriesByDept(dept);
	}
		
	
	@GetMapping(path="/findAllNullResponseQueries")
	public List<Query> findAllNullResponseQueries() {
		return (List<Query>) qService.findAllNullResponseQueries();
	}
	
	@GetMapping(path="/findAllResponseQueries")
	public List<Query> findAllResponseQueries() {
		return (List<Query>) qService.findAllResponseQueries();
	}
	
	@GetMapping(path="/findAllResponsesByEmpUsername/{username}")
	public List<Query> findAllResponsesByEmpUsername(@PathVariable("username")String username) {
		
		return qService.findAllResponsesByEmpUsername(username);
	}
	

}
