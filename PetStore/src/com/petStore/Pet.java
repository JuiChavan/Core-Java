package com.petStore;

import com.petStore.enums.Category;

public class Pet {
	public static int petIdGenrator=0;
	private int petId;
	private String name;
	private Category category;
	private String unitPrice;
	private String stocks;
	public int getPetIdGenrator() {
		return petIdGenrator;
	}
	public void setPetIdGenrator(int petIdGenrator) {
		this.petIdGenrator = petIdGenrator;
	}
	public int getPetId() {
		return petId;
	}
	public void setPetId(int petId) {
		this.petId = petId;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public Category getCategory() {
		return category;
	}
	public void setCategory(Category category) {
		this.category = category;
	}
	public String getUnitPrice() {
		return unitPrice;
	}
	public void setUnitPrice(String unitPrice) {
		this.unitPrice = unitPrice;
	}
	public String getStocks() {
		return stocks;
	}
	public void setStocks(String stocks) {
		this.stocks = stocks;
	}
	@Override
	public String toString() {
		return "Pet " +", petId=" + petId + ", name=" + name + ", category=" + category
				+ ", unitPrice=" + unitPrice + ", stocks=" + stocks ;
	}
	public Pet(String name, Category category, String unitPrice, String stocks) {
		petIdGenrator++;
		this.petId = petIdGenrator;
		this.name = name;
		this.category = category;
		this.unitPrice = unitPrice;
		this.stocks = stocks;
	}
	public Pet() {
		super();
		// TODO Auto-generated constructor stub
	}
	public Pet(int petId) {
		this.petId=petId;
		// TODO Auto-generated constructor stub
	}
	
	public boolean equals(Object o) {
		if(o instanceof Pet) {
			Pet p=(Pet) o;
			return this.getPetId()==p.getPetId();
		}
		return false;
		
	}
	
}
