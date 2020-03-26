package com.cups.api.entities;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name="Customer")
public class Customer {
	
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private int id; 
	
	@Column
	private String d_id;
	
	@Column 
	private String fname;
	
	@Column 
	private String lname;
	
	@Column
	private String recording; 
	
	@Column(name = "image_url")
	private String image;
	
	@Column
	private double balance;
	//primary Constructor
	
	@OneToMany(cascade=CascadeType.ALL,mappedBy="customer")
	private List<AuthToken> tokens;
	
	public Customer() {
		super();
	}


	//Constructors 
	public Customer(int id,String d_id, String fname, String lname, String recording, String image, Double balance) {
		super();
		this.id = id;
		this.d_id = d_id;
		this.fname = fname;
		this.lname = lname;
		this.recording = recording;
		this.image = image;
		this.balance = balance;
	}
	
	
	
	
	public Customer(int id, String d_id, String fname, String lname, String recording, String image, double balance,
			List<AuthToken> tokens) {
		super();
		this.id = id;
		this.d_id = d_id;
		this.fname = fname;
		this.lname = lname;
		this.recording = recording;
		this.image = image;
		this.balance = balance;
		this.tokens = tokens;
	}


	public int getId() {
		return id;
	}


	public void setId(int id) {
		this.id = id;
	}


	public String getD_id() {
		return d_id;
	}
	public void setD_id(String d_id) {
		this.d_id = d_id;
	}
	public String getFname() {
		return fname;
	}
	public void setFname(String fname) {
		this.fname = fname;
	}
	public String getLname() {
		return lname;
	}
	public void setLname(String lname) {
		this.lname = lname;
	}
	public String getRecording() {
		return recording;
	}
	public void setRecording(String recording) {
		this.recording = recording;
	}
	public String getImage() {
		return image;
	}
	public void setImage(String image) {
		this.image = image;
	}


	public Double getBalance() {
		return balance;
	}


	public void setBalance(Double balance) {
		this.balance = balance;
	}


	public List<AuthToken> getTokens() {
		return tokens;
	}


	public void setTokens(List<AuthToken> tokens) {
		this.tokens = tokens;
	}


	public void setBalance(double balance) {
		this.balance = balance;
	} 
	
	

}
