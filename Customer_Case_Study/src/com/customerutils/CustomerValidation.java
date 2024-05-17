package com.customerutils;

import java.time.LocalDate;
import java.time.Period;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.customerexception.CustomerException;
import com.servicePlan.ServicePlan;

import customer.Customer;

public class CustomerValidation {

	public static void checkDupalicateCustomer(String email,Map<String,Customer> customers) throws CustomerException  {
		Customer cust = new Customer(email);
		if(customers.containsKey(email)) {
			throw new CustomerException("Account already exists with tis email id !!! ");
		}
		}			
	
	
	public static  ServicePlan parseAndValidateServicePlanAndCharges(String plan ,int charges) throws CustomerException {
		ServicePlan  servicePlan=ServicePlan.valueOf(plan.toUpperCase());
		if(servicePlan.getPlanCost()==charges) {
		return servicePlan;	
		}
		else {
			throw new CustomerException("Charges amount does not match with selected service plan ");
		}		
	}
	
	public static void validatePassword(String password) throws CustomerException {
		String pattern="((?=.*\\d)(?=.*[a-z])(?=.*[#@$*]).{5,20})";
		if(!password.matches(pattern)) {
			throw new CustomerException("Password is invalid");
		}
	}
	
	public static void validateAge(LocalDate dob) throws CustomerException{
		LocalDate now=LocalDate.now();
		int age=Period.between(dob,now).getYears();
		System.out.println("age : "+age);
		if (age<18) {
			throw new CustomerException("Not eligible");
		}
		
	}
	public static  Customer validCustomerDetails(String firstName, String lastName, String email, String password, 
			 String dob,int registrationAmount,String servicePlan,Map<String,Customer> customers) throws CustomerException
	{
		checkDupalicateCustomer(email,customers);
		ServicePlan servicePlanObj=parseAndValidateServicePlanAndCharges(servicePlan,registrationAmount);
		LocalDate customerDob=LocalDate.parse(dob);
		return new Customer(firstName,lastName,email,password,customerDob,registrationAmount,servicePlanObj);	
	}

	
	public static Customer ValidDateUser(String email,String password,Map<String,Customer> customers) throws CustomerException{
		//dont use contains will return bool

		    Customer newCust=new Customer(email);		
			
			if(!customers.containsKey(email)) {
				throw new CustomerException("Invalid username or password !");
			}	
			Customer customer=customers.get(email);
			if(customer.getPassword().equals(password)) {
			System.out.println("Sign in completed \n "+customer );
			}
											
		return customer;
	}
	
	
	public static void UpdatePassword(Customer customer,String password) {
		
		customer.setPassword(password);
	}
	
	public static void DeleteCustomer(Map<String, Customer> customers ,String email,String password) throws CustomerException {
		Customer cust=ValidDateUser( email, password,customers );
		if(customers.containsKey(email)) {
			Customer deletedCust=customers.remove(email);
			System.out.println("\n deleted account \n "+deletedCust);
		}
	}
}

