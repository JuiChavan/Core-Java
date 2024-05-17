package com.bankaccountutils;

import java.time.LocalDate;
import java.util.List;

import com.bankaccount.BankAccount;
import com.bankaccount.BankAccountType;
import com.bankaccountexception.BankAccountException;

public class BankAccountValidations {
	
	static int minBal=1000;
	public static BankAccount validateInputs(int acctNo, String fName, String lastName, String acType, String dob,
			String creationDate, double balance) throws BankAccountException {
		BankAccountType acntType=validateAccountType(acType);
		validDateAccountBalanace(balance,acntType);
		LocalDate birthDate=LocalDate.parse(dob);
		LocalDate crDate=LocalDate.parse(creationDate);
		return new BankAccount(acctNo, fName, lastName, acntType, birthDate, crDate, balance);
	}

	public static BankAccountType validateAccountType(String type) {
		BankAccountType acntType=BankAccountType.valueOf(type.toUpperCase());
		return acntType;
	}
	public static void  validDateAccountBalanace(double balanace,BankAccountType type ) throws BankAccountException {
		if(balanace<type.getMinbal()) {
			throw new BankAccountException("Balance is low !!!");
		}
	}
	

	/*public static void validDateAccountsDetails(List<BankAccount> AccountList, int accNo1, int accNo2) throws BankAccountException {
		BankAccount acc1=new BankAccount(accNo1);
		if(AccountList.indexOf(acc1)==-1) {
			System.out.println(AccountList.indexOf(acc1));
			throw new BankAccountException("Acc 1 not found ");
		}
		
		BankAccount acc2=new BankAccount(accNo2);
		if(AccountList.indexOf(acc2)==-1) {
			System.out.println(AccountList.indexOf(acc2));
			throw new BankAccountException("Acc 2 not found ");
		}
	}
 */
	public static void validDateAccountsDetails(List<BankAccount> AccountList, int accNo1, int accNo2) throws BankAccountException {
	    boolean acc1Exists = false;
	    boolean acc2Exists = false;
	    for (BankAccount account : AccountList) {
	        if (account.getAcctNo() == accNo1) {
	            acc1Exists = true;
	        }
	        if (account.getAcctNo() == accNo2) {
	            acc2Exists = true;
	        }
	    }
	    if (!acc1Exists) {
	        throw new BankAccountException("Acc 1 not found");
	    }
	    if (!acc2Exists) {
	        throw new BankAccountException("Acc 2 not found");
	    }
	}

	

   
}
