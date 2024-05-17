package com.bankaccountutils;

import java.util.Comparator;

import com.bankaccount.BankAccount;

public class BankClassBalanceComparator implements Comparator<BankAccount> {

	@Override
	public int compare(BankAccount o1, BankAccount o2) {
		if(o2.getBalance()>o1.getBalance()) {
			return 1;
		}
	  if(o2.getBalance()==o1.getBalance()) {
			return 0;
		}
		
		return -1;
	}
}
