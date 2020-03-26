package com.cups.api.entities;

import java.util.Calendar;
import java.util.Date;


import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

@Entity
public class AuthToken {

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private int id;
	
	@Column
	private String token;
	
	@Column
	private Date validUntil;
	
	@ManyToOne
	
	private Customer customer;

	public AuthToken() {
		super();
		validUntil = Calendar.getInstance().getTime();
		validUntil.setHours(validUntil.getHours()+5);
	}

	public AuthToken(int id, String token, Date validUntil) {
		super();
		this.id = id;
		this.token = token;
		this.validUntil = validUntil;
	}

	public int getId() {
		return id;
	}

	public void setId(int customerId) {
		this.id = customerId;
	}

	public String getToken() {
		return token;
	}

	public void setToken(String token) {
		this.token = token;
	}

	public Date getValidUntil() {
		return validUntil;
	}

	public void setValidUntil(Date validUntil) {
		this.validUntil = validUntil;
	}

	public Customer getCustomer() {
		return customer;
	}

	public void setCustomer(Customer customer) {
		this.customer = customer;
	}

	@Override
	public String toString() {
		return "AuthToken [id=" + id + ", token=" + token + ", validUntil=" + validUntil + "]";
	}
	
	
}
