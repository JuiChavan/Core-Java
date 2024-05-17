package com.bankaccountutils;

import java.util.Comparator;

import com.bankaccount.BankAccount;

public class BankClassDobAndBalanaceComparator implements Comparator<BankAccount> {

	@Override
	public int compare(BankAccount o1, BankAccount o2) {
		if(o1.getDob().compareTo(o2.getDob())==0) {
			if(o1.getBalance()<o2.getBalance())
			{	return -1;
			}
			else if(o1.getBalance()==o2.getBalance())
			{	return 0;
			}
			else
				return 0;
		
		}
		else
			return o1.getDob().compareTo(o2.getDob());

}
	}
