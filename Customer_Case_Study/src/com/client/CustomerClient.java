package com.client;

import static com.customerutils.CustomerValidation.validCustomerDetails;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Scanner;
import java.util.TreeMap;

import com.customercompare.CustomerDobLnmComparator;
import com.customerutils.CustomerValidation;
import com.servicePlan.ServicePlan;

import customer.Customer;

public class CustomerClient {

	public static void main(String args[]) {
		boolean exit=false;
		try(Scanner sc=new Scanner(System.in)){		
		Map<String,Customer> customers=new HashMap<>();
		//Adding sample data :
		LocalDate customerDob1=LocalDate.parse("2000-03-07");
		LocalDate customerDob2=LocalDate.parse("2000-02-01");
		LocalDate customerDob3=LocalDate.parse("2000-02-01");
		LocalDate customerDob4=LocalDate.parse("2000-04-03");
		LocalDate customerDob5=LocalDate.parse("2000-06-05");


		Customer acc1=new Customer("amit","patil","a@gmail.com","ab@123",customerDob1,
				1000,ServicePlan.SILVER);
		Customer acc2=new Customer("jui","chavan","j@gmail.com","jc@123",customerDob2,
				2000,ServicePlan.GOLD);
		Customer acc3=new Customer("arun","jadhav","aj@gmail.com","az@123",customerDob3,
				1000,ServicePlan.SILVER);
		Customer acc4=new Customer("revati","lele","r@gmail.com","mn@123",customerDob4,
				1000,ServicePlan.SILVER);
		Customer acc5=new Customer("aarti","joshi","aj@gmail.com","jc123",customerDob4,
				2000,ServicePlan.GOLD);
		
		customers.put(acc1.getEmail(), acc1);
		customers.put(acc2.getEmail(), acc2);
		customers.put(acc3.getEmail(), acc3);
		customers.put(acc4.getEmail(), acc4);	
		
		System.out.println("Enter details fro cutomer : \n");
		while(!exit){
			try {
				System.out.println("Enter option");
				System.out.println("1. Sign up \n2. Sign in \n3. Update Password \n4. Show all  \n5. Delete user \n6. Sort by primary Key \n7. Sort by DOB & last name \n8. Remove \n9. Exit");
				switch(sc.nextInt()) {
				case 1:
					System.out.println("Sign UP \n enter customer details : \n first-name, last-name, email, password, DOB, registration amount , service plan \n");
					
					Customer c=validCustomerDetails(sc.next(),sc.next(),sc.next(),sc.next(),sc.next(),
							sc.nextInt(),sc.next(),customers);
					CustomerValidation.validatePassword(c.getPassword());
					CustomerValidation.validateAge(c.getDob());
					customers.put(c.getEmail(),c);
					break;
				case 2:
					System.out.println("Sign IN");
					System.out.println("Enter credentials : email and  password \n");
					Customer cust=CustomerValidation.ValidDateUser(sc.next(),sc.next(),customers);
					
					break;
				case 3:
					System.out.println("Update Password");
					System.out.println("Enter credentials for updating password :");
					System.out.println("Email : ");
					String email=sc.next();
					System.out.println("Password  : ");
					String password=sc.next();
					Customer customer=CustomerValidation.ValidDateUser(email,password,customers);
					System.out.println("Enter new Password");
					String upPassword=sc.next();
					CustomerValidation.UpdatePassword(customer,upPassword);
					break;
				case 4:
					for(Customer i:customers.values()) {
						System.out.println(i);
					}				
					break;
				case 5:
					System.out.println("Enter account credentials to delete acount ");
					System.out.println("Email : ");
					String emailC=sc.next();
					System.out.println("Password : ");
					String passwordC=sc.next();
					CustomerValidation.DeleteCustomer(customers,emailC,passwordC);
					break;
				case 6:
					TreeMap<String, Customer> sortedCustomerMap = new TreeMap<>(customers);
					System.out.println("Sorted accts as per asc acct nos");
					for (Customer a : sortedCustomerMap.values())
						System.out.println(a);

					break;
				case 7:

					List<Customer> custList=new ArrayList<>(customers.values());
					Collections.sort(custList,new CustomerDobLnmComparator());
					for(Customer i:custList) {
						System.out.println(i);
					}
					break;
				case 8:
					System.out.println("Remove all customer details from specified plan born after specified date");
					System.out.println("Enter date : ");
					String s_date=sc.next();
					LocalDate dt=LocalDate.parse(s_date);
					System.out.println(" Enter service plan ");
					String s_plan=sc.next();
					System.out.println(" Enter service charges ");
					int chrgs=sc.nextInt();
					
					ServicePlan plan=CustomerValidation.parseAndValidateServicePlanAndCharges(s_plan,chrgs);
					
					break;
				case 9:
					exit=true;
					break;
					
				}
			}
			catch(Exception e) {
				System.out.println(e.getMessage());
				sc.nextLine();

			}
		}
		}
	}
}
