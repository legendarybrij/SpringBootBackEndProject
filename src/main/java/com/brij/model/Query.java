package com.brij.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity (name = "queries")
public class Query {
	@Id @GeneratedValue (strategy = GenerationType.IDENTITY)
	private int queryId;
	@Column
	private int cusId;
	@Column
	private String department;
	@Column
	private String queryDescription;
	@Column
	private String queryResponse;
	@Column
	private String empUsername;
	@Column
	private int rating=0;
	
	public String getEmpUsername() {
		return empUsername;
	}

	public void setEmpUsername(String empUsername) {
		this.empUsername = empUsername;
	}


	public int getRating() {
		return rating;
	}

	public void setRating(int rating) {
		this.rating = rating;
	}

	public int getCusId() {
		return cusId;
	}

	public void setCusId(int cusId) {
		this.cusId = cusId;
	}

	public int getQueryId() {
		return queryId;
	}
	public void setQueryId(int queryId) {
		this.queryId = queryId;
	}
	public String getDepartment() {
		return department;
	}
	public void setDepartment(String queryDepartment) {
		this.department = queryDepartment;
	}
	public String getQueryDescription() {
		return queryDescription;
	}
	public void setQueryDescription(String queryDescription) {
		this.queryDescription = queryDescription;
	}
	public String getQueryResponse() {
		return queryResponse;
	}
	public void setQueryResponse(String queryResponse) {
		this.queryResponse = queryResponse;
	}
	

	
	
	
	
	

}
