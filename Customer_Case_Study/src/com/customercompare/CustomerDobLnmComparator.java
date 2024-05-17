package com.customercompare;

import java.util.Comparator;

import customer.Customer;

public class CustomerDobLnmComparator implements Comparator <Customer> {

	@Override
	public int compare(Customer c1, Customer c2) {

		if(c1.getDob().compareTo(c2.getDob())==0) {
			return c1.getLastName().compareTo(c2.getLastName());					
		}
		else
			return c1.getDob().compareTo(c2.getDob());
	}


}
