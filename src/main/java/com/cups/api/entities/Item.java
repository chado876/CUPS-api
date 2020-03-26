package com.cups.api.entities;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="items")
public class Item {
	
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private int id;
	
	@Column
	private String name;
	

	@Column
	private String category;
	
	@Column
	private double cost;
	
	@Column
	private int stock;
	
	@Column(name="url")
	private String url;
	
	@Column(name="asl")
	private String asl;
	
	public Item() {
		super();
	}

	public Item(int id,String name, String category, double cost, int stock, String url, String asl) {
		super();
		this.id = id;
		this.name = name;
		this.category = category;
		this.cost = cost;
		this.stock = stock;
		this.url = url;
		this.asl = asl;
	}
	
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}
	
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getCategory() {
		return category;
	}
	public void setCategory(String category) {
		this.category = category;
	}
	public double getCost() {
		return cost;
	}
	public void setCost(double cost) {
		this.cost = cost;
	}
	public int getStock() {
		return stock;
	}
	public void setStock(int stock) {
		this.stock = stock;
	}
	public String getUrl() {
		return url;
	}
	public void setUrl(String url) {
		this.url = url;
	}
	public String getAsl() {
		return asl;
	}
	public void setAsl(String asl) {
		this.asl = asl;
	}

	@Override
	public String toString() {
		return "Item [id=" + id + ", name=" + name + ", category=" + category + ", cost=" + cost + ", stock=" + stock
				+ ", url=" + url + ", asl=" + asl + "]";
	}
	
	
	
}
