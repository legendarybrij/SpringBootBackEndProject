package com.brij.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestBody;

import com.brij.dao.QueryRepository;
import com.brij.model.Customer;
import com.brij.model.Employee;
import com.brij.model.Query;

@Service
public class QueryService {
	@Autowired
	QueryRepository qRepo;
	
	public Query createQuery(Query q){
		
		return qRepo.save(q);
	}
	
	public Query updateQuery(Query q){
//		Query oldQ= findQueryById(q.getQueryId());
//		oldQ = q;
//		qRepo.save(oldQ);
		return qRepo.save(q);
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
	
	public List<Query> findAllNullResponseQueriesByDept(String dept) {
		List<Query> list = new ArrayList<Query>();
		list = qRepo.findAllByDepartment(dept);
		List<Query> nullList = new ArrayList<Query>();
		for(Query newlist : list) {
			if(newlist.getQueryResponse() == null || newlist.getQueryResponse().length()<1 ) {
				nullList.add(newlist);
			}
		}
		
		return nullList;
	}
	
	public List<Query> findAllNullResponseQueries() {
		List<Query> list = (List<Query>) qRepo.findAll();

		List<Query> nullList = new ArrayList<Query>();
		for(Query newlist : list) {
			if(newlist.getQueryResponse().trim().length()==1 || newlist.getQueryResponse().length()==0 ) {
				nullList.add(newlist);
			}
		}
		
		return nullList;
	}
	
	public List<Query> findAllResponseQueries() {
		List<Query> list = (List<Query>) qRepo.findAll();

		List<Query> notNullList = new ArrayList<Query>();
		for(Query newlist : list) {
			if(newlist.getQueryResponse().trim().length()>1) {
				notNullList.add(newlist);
			}
		}
		
		return notNullList;
	}
	
}
