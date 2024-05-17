package com.bankaccount;

import java.time.LocalDate;
import java.util.Objects;


public class BankAccount implements Comparable<BankAccount> {
	private int acctNo;
	private String firstName;
	private String lastName;
	private BankAccountType acType;
	private LocalDate dob;
	private LocalDate creationDate;
	private double balance;
	public static int counter=0;
	
	public BankAccount() {
		super();
		// TODO Auto-generated constructor stub
	}
	public BankAccount(int acctNo) {
		this.acctNo = acctNo;
	}
	
	
	public BankAccount(int acctNo, String firstName, String lastName, BankAccountType acType, LocalDate dob,
			LocalDate creationDate, double balance) {
		super();
		this.acctNo = acctNo;
		this.firstName = firstName;
		this.lastName = lastName;
		this.acType = acType;
		this.dob = dob;
		this.creationDate = creationDate;
		this.balance = balance;
	}
	public int getAcctNo() {
		return acctNo;
	}
	public void setAcctNo(int acctNo) {
		this.acctNo = acctNo;
	}
	public String getFirstName() {
		return firstName;
	}
	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}
	public String getLastName() {
		return lastName;
	}
	public void setLastName(String lastName) {
		this.lastName = lastName;
	}
	public BankAccountType getAcType() {
		return acType;
	}
	public void setAcType(BankAccountType acType) {
		this.acType = acType;
	}
	public LocalDate getDob() {
		return dob;
	}
	public void setDob(LocalDate dob) {
		this.dob = dob;
	}
	public LocalDate getCreationDate() {
		return creationDate;
	}
	public void setCreationDate(LocalDate creationDate) {
		this.creationDate = creationDate;
	}
	public double getBalance() {
		return balance;
	}
	public void setBalance(double balance) {
		this.balance = balance;
	}

	@Override
	public String toString() {
		return "BankAccount [acctNo=" + acctNo + ", firstName=" + firstName + ", lastName=" + lastName + ", acType="
				+ acType + ", dob=" + dob + ", creationDate=" + creationDate + ", balance=" + balance + "]";
	}
	
	
	
	public boolean equals(Object o) {
		if(o instanceof BankAccount) {
			BankAccount b=(BankAccount)o;
			return this.acctNo==b.acctNo;
		}
		return false;
		
	}
	@Override
	public int compareTo(BankAccount o) {
		if(this.acctNo<o.acctNo)
			return -1;
		else if(this.acctNo==o.acctNo)
			return 0;
		else
			return 0;
	}
	
	
	
	
}
