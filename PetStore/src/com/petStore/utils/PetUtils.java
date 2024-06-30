package com.petStore.utils;

import java.util.List;

import com.petStore.Order;
import com.petStore.Pet;
import com.petStore.User;
import com.petStore.enums.Category;
import com.petStore.enums.Status;
import com.petStore.enums.Utype;
import com.petStore.exception.PetException;

public class PetUtils {

	public static Pet addPet(String name, String category, String unitPrice, String stocks) {
		Category category1 = Category.valueOf(category.toUpperCase());
		Pet p = new Pet(name, category1, unitPrice, stocks);
		return p;
	}

	public static Pet update(Pet p, String stocks) {
		p.setStocks(stocks);
		return p;

	}

	public static Pet getPet(int index, List<Pet> petList) throws PetException {
		Pet p = null;
//		for (Pet p : petList) {
//			if (p.getPetId() == index) {
//				p1 = p;
//			}
//		}
		Pet p1=new Pet(index);
		int i=petList.indexOf(p1);
		if(i==-1)
			throw new PetException("NE");
		else
		p=petList.get(i);
		System.out.println(p);
		return p;
	}

	public static Order addOrder(String petId, double stock, Status status, List<Order> orderList) {
		return new Order(petId, stock, status);
	}

	public static Order getOrderById(int id, List<Order> orderList) throws PetException {
		Order order = null;
		for (Order o : orderList) {
			if (o.getOrderId() == id) {

				order = o;
			}
		}
		return order;
		// return orderList.get(id);
	}

	public static Order updateOrderStatus(Order order, String status, List<Order> orderList) {

		Status s = Status.valueOf(status);

		order.setStatus(s);

		return order;
	}
	
	public static User getUserByEmailType(String email,Utype t,List<User> user) throws PetException {
		User u1=new User(email,t);
		int id=user.indexOf(u1);
		if(id==-1)
			throw new PetException("NE");
		u1=user.get(id);
		System.out.println("id "+u1.getEmail());
		return u1;
	}
}
