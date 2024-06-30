package com.petStore;

import java.util.Objects;

import com.petStore.enums.Status;

public class Order {
	public static int orderIdGenrator = 0;
	private int orderId;
	private String petId;
	private double quantity;
	private Status status;

	public int getOrderIdGenrator() {
		return orderIdGenrator;
	}

	public void setOrderIdGenrator(int orderIdGenrator) {
		this.orderIdGenrator = orderIdGenrator;
	}

	public int getOrderId() {
		return orderId;
	}

	public void setOrderId(int orderId) {
		this.orderId = orderId;
	}

	public String getPetId() {
		return petId;
	}

	public void setPetId(String petId) {
		this.petId = petId;
	}

	public double getQuantity() {
		return quantity;
	}

	public void setQuantity(double quantity) {
		this.quantity = quantity;
	}

	public Status getStatus() {
		return status;
	}

	public void setStatus(Status status) {
		this.status = status;
	}

	public Order(String petId, double quantity, Status status) {
		super();
		orderIdGenrator ++;
		this.orderId = orderIdGenrator;
		this.petId = petId;
		this.quantity = quantity;
		this.status = status;
		
	}

	@Override
	public String toString() {
		return "Order [orderIdGenrator=" + orderIdGenrator + ", orderId=" + orderId + ", petId=" + petId + ", quantity="
				+ quantity + ", status=" + status + "]";
	}

	public Order() {
		super();
		// TODO Auto-generated constructor stub
	}

	@Override
	public int hashCode() {
		return Objects.hash(petId);
	}

	@Override
	public boolean equals(Object obj) {
		if(obj instanceof Order) {
			Order o = (Order) obj;
			return this.equals(o.getOrderId());
		}
		return false;
		
	}

	
}
