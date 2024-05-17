package com.bankaccountutils;

import java.util.Iterator;
import java.util.List;

import com.bankaccount.BankAccount;
import com.bankaccount.BankAccountType;
import com.bankaccountexception.BankAccountException;

public class BankAccountMethods {
	BankAccountValidations bv=new BankAccountValidations();
	public static void displayAccountDetails(List<BankAccount> AccountList) {
		if(AccountList.size()==0){
			System.out.println("No acc exists");
		}
		Iterator<BankAccount> itr=AccountList.iterator();
		while(itr.hasNext())
			{
				System.out.println(itr.next());
			}		
	}
	
	public static BankAccount showAccountDetails(List<BankAccount> AccountList,int accNo)throws BankAccountException {
		BankAccount acc=new BankAccount(accNo);
		int index=AccountList.indexOf(acc);
		 if (index == -1) {
			  throw new BankAccountException("Account not found Accno: "+accNo);   
		    }
		else {
		    return AccountList.get(index); 
		        }
	}
	
	public static void displayByType(List<BankAccount> AccountList,BankAccountType type) {
		System.out.println("Account Type "+type);
		for(BankAccount b:AccountList) {
			if(b.getAcType()==type){
				System.out.println(b);
			}
		}
	}
	
	public static void withdraw(List<BankAccount>AccountList,BankAccount account,double amount) throws BankAccountException {
	    System.out.println("before"+account);
	    BankAccountValidations.validDateAccountBalanace(account.getBalance() - amount,account.getAcType());
	    double newBal = account.getBalance() - amount;
	    account.setBalance(newBal);
	    AccountList.set(AccountList.indexOf(account), account);
	    System.out.println("Withdraw successful");   
	    System.out.println("after"+account);
	    
	}

	public static void deposite(List<BankAccount>AccountList,BankAccount account,double amount) throws BankAccountException {
	    System.out.println("before"+account);
		double newBal = account.getBalance() + amount;
	    account.setBalance(newBal);
	    AccountList.set(AccountList.indexOf(account), account);
	    System.out.println("Deposit successful");
	    System.out.println("after"+account);

	}

	public static void transfer(List<BankAccount>AccountList,BankAccount account1,BankAccount account2,double amount) throws BankAccountException {
		withdraw(AccountList,account2,amount); 
		deposite(AccountList,account1,amount); 
	    System.out.println("transfer successful");

	}

	public static void deleteAccount(List<BankAccount> accountList, BankAccount delteAcc) {
		accountList.remove(delteAcc);
		System.out.println("Accounted closed");
	}
	
	
}
