package com.StyleWithPen.client;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.ObjectInput;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.PrintWriter;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import javax.imageio.stream.FileImageInputStream;

import com.StyleWithPen.Pen;
import com.StyleWithPen.enums.Brand;
import com.StyleWithPen.enums.Material;
import com.StyleWithPen.exception.PenException;
import com.StyleWithPen.utils.PenUtils;

import static com.StyleWithPen.utils.PenUtils.*;

public class Client {

	public static void main(String[] args) {
		try (Scanner sc = new Scanner(System.in)) {
			boolean exit = false;
			LocalDate d1 = LocalDate.parse("2023-01-01");
			LocalDate d2 = LocalDate.parse("2024-02-01");
			LocalDate d3 = LocalDate.parse("2024-03-01");

			List<Pen> penList = new ArrayList<>();
			penList.add(new Pen(Brand.CELLO, "black", "black", Material.ALLOY, 10, d1, d1, 15, 10));
			penList.add(new Pen(Brand.PARKER, "blue", "blue", Material.PLASTIC, 10, d1, d2, 15, 10));

			while (!exit) {
				try {
					System.out.println("\n1. Add new Pen \n2. Update stock of aPen "
							+ "\n3.Set discount of 20% for all the pens which are not at all sold in last 3 months"
							+ "\n4. Remove Pens which are never sold once listed in 9 months \n5. Show all");
					System.out.println("\n");

					switch (sc.nextInt()) {

					case 1:
						System.out.println(
								"Enter pen details to add pen: brand,color,inkColor,material,stock,stock_Update_Date,\r\n"
										+ "stock_Listing_Date,price,discounts");
						Pen p = addPen(sc.next(), sc.next(), sc.next(), sc.next(), sc.nextInt(), sc.next(), sc.next(),
								sc.nextDouble(), sc.nextDouble(), penList);
						penList.add(p);
						System.out.println("pen is added");
						break;
					case 2:
						System.out.println("updating pen stocks");
//						System.out.println("Enter brand name ,color,inkColor,material");
//						Pen p1 = getPenToUpadateStocks(sc.next(), sc.next(), sc.next(), sc.next(), penList);
//						System.out.println(p1);
//						System.out.println("Enter stock count to update ");
//						updateStock(sc.nextInt(), p1, penList);
//						System.out.println(p1);
						
						System.out.println("enter id to update stocks");
						Pen p1 = updateStocks(sc.nextInt(), sc.nextInt(), penList);
						System.out.println("Updated pen "+p1);
                        
						break;
					case 3:
						System.out.println("Setting discount for pen older than 3 months");
						penList.forEach(s -> System.out.println(s));
						discountPen(penList);
						penList.forEach(b -> System.out.println(b));
						break;
					case 4:
						System.out.println("Removing Pens which are never sold once listed in 9 months");
						penList.forEach(x -> System.out.println(x));
						removeOldPens(penList);
						penList.forEach(y -> System.out.println(y));

						break;
					case 5:
						penList.forEach(pen -> System.out.println(pen));
						break;

					case 0:
						exit = true;
						break;
					}

				} catch (Exception e) {
					System.out.println(e.getMessage());
					sc.nextLine();
				}
			}
		}
	}

}
