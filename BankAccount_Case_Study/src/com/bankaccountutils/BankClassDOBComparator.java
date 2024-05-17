package com.bankaccountutils;

import java.util.Comparator;

import com.bankaccount.BankAccount;

public class BankClassDOBComparator implements Comparator<BankAccount>  {

	@Override
	public int compare(BankAccount o1, BankAccount o2) {		
		return o1.getDob().compareTo(o2.getDob()); 
	}

	


}
