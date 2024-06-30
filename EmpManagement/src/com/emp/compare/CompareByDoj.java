package com.emp.compare;

import java.util.Comparator;

import com.emp.Employee;

public class CompareByDoj implements Comparator<Employee> {
	public CompareByDoj() {
		// TODO Auto-generated constructor stub
	}

	@Override
	public int compare(Employee o1, Employee o2) {
		return o1.getDate_of_joining().compareTo(o2.getDate_of_joining());
	}

}
