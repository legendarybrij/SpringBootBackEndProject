package com.brij.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity(name = "customers")
public class Customer {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int cusId;
	@Column
	private String cusName;
	@Column
	private String cusEmail;
	@Column
	private String cusContact;
	@Column
	private String cusAddress;
	@Column
	private String cusUsername;
	

	public String getCusUsername() {
		return cusUsername;
	}
	public void setCusUsername(String cusUsername) {
		this.cusUsername = cusUsername;
	}
	public int getCusId() {
		return cusId;
	}
	public void setCusId(int cusId) {
		this.cusId = cusId;
	}
	public String getCusName() {
		return cusName;
	}
	public void setCusName(String cusName) {
		this.cusName = cusName;
	}
	public String getCusEmail() {
		return cusEmail;
	}
	public void setCusEmail(String cusEmail) {
		this.cusEmail = cusEmail;
	}
	public String getCusContact() {
		return cusContact;
	}
	public void setCusContact(String cusContact) {
		this.cusContact = cusContact;
	}
	public String getCusAddress() {
		return cusAddress;
	}
	public void setCusAddress(String cusAddress) {
		this.cusAddress = cusAddress;
	}
	
	@Override
	public String toString() {
		return "Customer [cusId=" + cusId + ", cusName=" + cusName + ", cusEmail=" + cusEmail + ", cusContact="
				+ cusContact + ", cusAddress=" + cusAddress + "]";
	}
	
	
	
	
}
