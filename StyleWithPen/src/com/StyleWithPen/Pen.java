package com.StyleWithPen;

import java.time.LocalDate;

import com.StyleWithPen.enums.Brand;
import com.StyleWithPen.enums.Material;

public class Pen implements Comparable<Pen> {
	public static int idGenrator=0;
	private int id;
	private Brand brand;
	private String color;
	private String inkColor;
	private Material material;
	int stock;
	private LocalDate stock_Update_Date;
	private LocalDate stock_Listing_Date;
	private double price;
	private double Discounts;

	public Pen() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Pen(Brand brand, String color, String inkColor, Material material, int stock, LocalDate stock_Update_Date,
			LocalDate stock_Listing_Date, double price, double discounts) {
		super();
		idGenrator++;
		this.id=idGenrator;
		this.brand = brand;
		this.color = color;
		this.inkColor = inkColor;
		this.material = material;
		this.stock = stock;
		this.stock_Update_Date = stock_Update_Date;
		this.stock_Listing_Date = stock_Listing_Date;
		this.price = price;
		Discounts = discounts;
	}

	public Pen(int id) {
		this.id=id;
	}

	@Override
	public String toString() {
		return "Pen [id=" + id + ", brand=" + brand + ", color=" + color + ", inkColor=" + inkColor + ", material="
				+ material + ", stock=" + stock + ", stock_Update_Date=" + stock_Update_Date + ", stock_Listing_Date="
				+ stock_Listing_Date + ", price=" + price + ", Discounts=" + Discounts + "]";
	}

	public Brand getBrand() {
		return brand;
	}

	public void setBrand(Brand brand) {
		this.brand = brand;
	}

	public String getColor() {
		return color;
	}

	public void setColor(String color) {
		this.color = color;
	}

	public String getInkColor() {
		return inkColor;
	}

	public void setInkColor(String inkColor) {
		this.inkColor = inkColor;
	}

	public Material getMaterial() {
		return material;
	}

	public void setMaterial(Material material) {
		this.material = material;
	}

	public int getStock() {
		return stock;
	}

	public void setStock(int stock) {
		this.stock = stock;
	}

	public LocalDate getStock_Update_Date() {
		return stock_Update_Date;
	}

	public void setStock_Update_Date(LocalDate stock_Update_Date) {
		this.stock_Update_Date = stock_Update_Date;
	}

	public LocalDate getStock_Listing_Date() {
		return stock_Listing_Date;
	}

	public void setStock_Listing_Date(LocalDate stock_Listing_Date) {
		this.stock_Listing_Date = stock_Listing_Date;
	}

	public double getPrice() {
		return price;
	}

	public void setPrice(double price) {
		this.price = price;
	}

	public double getDiscounts() {
		return Discounts;
	}

	public void setDiscounts(double discounts) {
		Discounts = discounts;
	}

	public int getId() {
		return id;
	}

	@Override
	public int compareTo(Pen o) {
		if(this.id<o.id)
			return -1;
		else if(this.id==o.id)
			return 0;
		else
		return -1;
	}
	
	@Override
	public boolean equals(Object o) {
		if(o instanceof Pen)
		{
			Pen p=(Pen)o;
			if(this.id==p.id)
				return true;
		}		
		return false;		
	}

	@Override
	public int hashCode() {
		return id;
	}
	

}
