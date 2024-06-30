package com.emp;

import java.io.Serializable;
import java.time.LocalDate;

import com.emp.enums.Emp_Type;

public class Employee implements Serializable {
	public static int idGenrator = 0;
	private int id;
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	private String Name;
	private LocalDate Date_of_joining;
	private String Phone_Number;
	private String Aadhaar_number;
	private double Fte_msal;
	private double Pte_hsal;
	private Emp_Type etype;

	public String getName() {
		return Name;
	}

	public void setName(String name) {
		Name = name;
	}

	public LocalDate getDate_of_joining() {
		return Date_of_joining;
	}

	public void setDate_of_joining(LocalDate date_of_joining) {
		Date_of_joining = date_of_joining;
	}

	public String getPhone_Number() {
		return Phone_Number;
	}

	public void setPhone_Number(String phone_Number) {
		Phone_Number = phone_Number;
	}

	public String getAadhaar_number() {
		return Aadhaar_number;
	}

	public void setAadhaar_number(String aadhaar_number) {
		Aadhaar_number = aadhaar_number;
	}

	public double getFte_msal() {
		return Fte_msal;
	}

	public void setFte_msal(double fte_msal) {
		Fte_msal = fte_msal;
	}

	public double getPte_hsal() {
		return Pte_hsal;
	}

	public void setPte_hsal(double pte_hsal) {
		Pte_hsal = pte_hsal;
	}

	public Emp_Type getEtype() {
		return etype;
	}

	public void setEtype(Emp_Type etype) {
		this.etype = etype;
	}

	@Override
	public String toString() {

		if (this.getEtype() == Emp_Type.FTE) {
			return "Employee id : " + id + " Name=" + Name + ", Date_of_joining=" + Date_of_joining + ", Phone_Number="
					+ Phone_Number + ", Aadhaar_number=" + Aadhaar_number + ", Fte_msal=" + Fte_msal + ", etype="
					+ etype + "]";
		} else {
			return "Employee id : " + id + " Name=" + Name + ", Date_of_joining=" + Date_of_joining + ", Phone_Number="
					+ Phone_Number + ", Aadhaar_number=" + Aadhaar_number + ", Pte_hsal=" + Pte_hsal + ", etype="
					+ etype + "]";
		}

	}

	public Employee(String name, LocalDate date_of_joining, String phone_Number, String aadhaar_number, double sal,
			Emp_Type etype) {
		this.idGenrator++;
		this.id = idGenrator;
		Name = name;
		Date_of_joining = date_of_joining;
		Phone_Number = phone_Number;
		Aadhaar_number = aadhaar_number;
		this.etype = etype;
		if (this.etype == Emp_Type.FTE) {
			Fte_msal = sal;
			Pte_hsal = 0;

		}
		if (this.etype == Emp_Type.PTE) {
			Pte_hsal = sal;
			Fte_msal = 0;
		}
	}

	public Employee() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Employee(String Aadhaar_number) {
		this.Aadhaar_number = Aadhaar_number;
	}

	public boolean equals(Object o) {
		if (o instanceof Employee) {
			Employee e = (Employee) o;
			return this.getAadhaar_number().equals(e.getAadhaar_number());
		}
		return false;
	}

}
