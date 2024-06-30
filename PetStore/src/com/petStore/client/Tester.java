package com.petStore.client;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.PrintWriter;
import java.util.ArrayList;
import static com.petStore.utils.PetUtils.*;
import java.util.List;
import java.util.Scanner;

import com.petStore.Order;
import com.petStore.Pet;
import com.petStore.User;
import com.petStore.enums.Category;
import com.petStore.enums.Status;
import com.petStore.enums.Utype;
import com.petStore.exception.PetException;
import com.petStore.utils.PetUtils;

public class Tester {

	public static void main(String[] args) {
		try (Scanner sc = new Scanner(System.in)) {
			boolean exit = false;
			List<User> user = new ArrayList<>();
			user.add(new User("a", "b", Utype.ADMIN));
			user.add(new User("c", "d", Utype.CUSTOMER));
			List<Pet> petList = new ArrayList<>();
			petList.add(new Pet("pet1", Category.CAT, "10", "100"));

			List<Order> orderList = new ArrayList<>();
			orderList.add(new Order("1", 1, Status.PLACED));
			orderList.add(new Order("1", 4, Status.PLACED));
			while (!exit) {
				try {
					System.out.println("1.Login\r\n" 
							+ "2.Add new Pet (Admin only functionality)\r\n"
							+ "3.Update Pet details (Admin only functionality)\r\n" 
							+ "4.Display all available pets\r\n"
							+ "5.Order a Pet\r\n" 
							+ "6.Check order status by Order Id\r\n"
							+ "7.Update order status (Admin only functionality)");
					switch (sc.nextInt()) {
					case 1:
						User u1 = new User("c", "s", Utype.ADMIN);
						System.out.println(u1.getEmail() + " " + u1.getPass());
						boolean flag1 = User.login(u1, user);
						if (flag1 == false)
							throw new PetException("Invalid credentials");
						User.setUtype(u1.getUtype());
						System.out.println("logged in as " + u1.getUtype());
						break;
					case 2:
						System.out.println("In Add new Pet");
						if (User.getUtype() == Utype.ADMIN) {
							System.out.println("logged in as" + User.getUtype());
							System.out.println("enter details -name,category,unitPrice,stocks ");
							Pet p = addPet(sc.next(), sc.next(), sc.next(), sc.next());
							petList.add(p);
							System.out.println("pet added " + p);
						} else {
							System.out.println("--NA--");
						}
						break;
					case 3:
						if (User.getUtype() == Utype.ADMIN) {
							System.out.println("Update Pet details");
							System.out.println("Enter pet id");
							Pet p = getPet(sc.nextInt(), petList);
							System.out.println(p);
							System.out.println("Enter stocks to update ");
							update(p, sc.next());
							System.out.println(p);
						} else {
							System.out.println("--NA--");
						}
						break;
					case 4:
						if (petList.size() != 0) {
							System.out.println("Display all available pets");
							petList.forEach(p1 -> System.out.println(p1));
						} else {
							System.out.println("--NA--");
						}

						break;
					case 5:
						if (User.isAuthorized() && User.getUtype() != Utype.ADMIN) {
							System.out.println("utype" + User.getUtype());
							System.out.println("order pet");
							System.out.println("enter details -petId,quantity");
							Order o = addOrder(sc.next(), sc.nextDouble(), Status.PLACED, orderList);
							orderList.add(o);
							System.out.println("order is placed " + o);
						} else
							System.out.println("--NA--");
						break;
					case 6:
						System.out.println("chk order status by id enter id ");
						Order order = getOrderById(sc.nextInt(), orderList);
						if (order == null)
							throw new PetException("order not found");
						System.out.println("Status of order id " + order.getOrderId() + " is " + order.getStatus());
						break;
					case 7:
						if (User.getUtype() == Utype.ADMIN && User.isAuthorized()) {
							System.out.println("in update order status");
							System.out.println("enter id");
							Order order1 = getOrderById(sc.nextInt(), orderList);
							System.out.println("enter status to update");
							Order order2 = updateOrderStatus(order1, sc.next(), orderList);
							System.out.println("Update : \n " + order2);
						} else
							System.out.println("--NA--");
						break;
					case 8:
						System.out.println("file ip , enter filnm to write ");
						try (PrintWriter pw = new PrintWriter(new FileWriter(sc.next()))) {
							petList.stream().forEach(s -> pw.print(s));
							System.out.println("w done");
						}
						System.out.println("file ip , enter filnm to read ");
						try (BufferedReader buf = new BufferedReader(new FileReader(sc.next()))) {
							buf.lines().forEach(l->System.out.println(l));
						}
						break;
					case 9:
						User u= PetUtils.getUserByEmailType("a",Utype.ADMIN,user);
						System.out.println(u);
					case 0:
						exit = true;
						break;
					}
				} catch (Exception e) {
					System.out.println(e.getMessage());
				}
			}
		}

	}

}
