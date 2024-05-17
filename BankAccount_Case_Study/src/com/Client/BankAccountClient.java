package com.Client;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

import com.bankaccount.BankAccount;
import com.bankaccount.BankAccountType;
import com.bankaccountutils.BankAccountDobBalanceDescComparator;
import com.bankaccountutils.BankAccountMethods;
import com.bankaccountutils.BankAccountValidations;
import com.bankaccountutils.BankClassBalanceComparator;
import com.bankaccountutils.BankClassDOBComparator;
import com.bankaccountutils.BankClassDobAndBalanaceComparator;


public class BankAccountClient {

	public static void main(String[] args) {
		boolean exit=false;
		List <BankAccount> AccountList = new ArrayList<>();
		LocalDate d1=LocalDate.parse("2000-10-02");
		LocalDate d2=LocalDate.parse("2000-10-03");
		LocalDate d3=LocalDate.parse("2000-10-02");
		LocalDate d4=LocalDate.parse("2000-10-05");
		
		BankAccount ac1=new BankAccount(123,"J","C",BankAccountType.DMAT,d1,d2,43000);	
		BankAccount ac2=new BankAccount(789,"A","B",BankAccountType.CURRENT,d3,d4,7000);
		BankAccount ac3=new BankAccount(111,"Q","W",BankAccountType.FD,d1,d3,55000);
		BankAccount ac4=new BankAccount(222,"M","N",BankAccountType.LOAN,d2,d4,30000);
	
		AccountList.add(ac1);
		AccountList.add(ac2);
		AccountList.add(ac3);
		AccountList.add(ac4);
		
		try (Scanner sc=new Scanner(System.in)){
			
			while(!exit) {
				try {					
					BankAccountMethods bu=new BankAccountMethods();
					System.out.println("Enter choice "
							+ "\n1. Add account \n2. Deposite \n3. Withdraw "
							+ "\n4. Transfer  \n5. Show all account \n6. Get account details"
							+ "\n7. Close account \n8. Display account by account type "
							+ "\n9. isplay A/Cs  sorted by ac nos (asc)"
							+ "\n10. Display A/Cs  sorted by ac balance (desc)"
							+ "   \n0. Exit");
				
					switch(sc.nextInt()) {
					case 1:	
						System.out.println("Enter :\n Acct no , First name ,last name , Account type , DOB , Acc creation date , balance  ");
						BankAccount account =BankAccountValidations.validateInputs(sc.nextInt(), sc.next(), sc.next(), sc.next(), sc.next(),
								sc.next(), sc.nextDouble());
						AccountList.add(account);
						System.out.println("Account creation successful !! ");
						break;
					case 2:
						System.out.println("Deposite");
						System.out.println("Enter account number and amount to deposite");
						int accNo1=sc.nextInt();
						double amount1 =sc.nextDouble();
						BankAccount acc1=BankAccountMethods.showAccountDetails(AccountList,accNo1);
						BankAccountMethods.deposite(AccountList,acc1,amount1);
						break;
					case 3:
						System.out.println("Withdraw");
						System.out.println("Enter account number and amount to withdraw");
						int accNo2=sc.nextInt();
						double amount2 =sc.nextDouble();
						BankAccount acc2=BankAccountMethods.showAccountDetails(AccountList,accNo2);
						BankAccountMethods.withdraw(AccountList,acc2,amount2);
						break;
					case 4:
						System.out.println("Transfer");
						System.out.println("Enter two account number and amount to deposite");
						int acctNo1=sc.nextInt();
						int acctNo2=sc.nextInt();
						double amount=sc.nextDouble();
						
						BankAccount acct1=BankAccountMethods.showAccountDetails(AccountList,acctNo1);

						BankAccount acct2=BankAccountMethods.showAccountDetails(AccountList,acctNo2);

						BankAccountMethods.transfer( AccountList, acct1, acct2, amount);
						break;
					case 5:
						System.out.println("All accounts ");
						System.out.println(AccountList.size());
						BankAccountMethods.displayAccountDetails(AccountList);
//						for(BankAccount b:AccountList)
//							System.out.println(b);
						break;
					case 6:
						System.out.println("Geting Account information ");	
						System.out.println("Enter the account number");
						BankAccount acc=BankAccountMethods.showAccountDetails(AccountList,sc.nextInt());
						break;
					case 7:
						System.out.println(" Close account");
						System.out.println("Enter account number to delete ");
						BankAccount delteAcc=BankAccountMethods.showAccountDetails(AccountList,sc.nextInt());
						BankAccountMethods.deleteAccount(AccountList,delteAcc);
						break;
					case 8:
						System.out.println("Display account by account type");
						BankAccountType type=BankAccountValidations.validateAccountType(sc.next());
						BankAccountMethods.displayByType(AccountList,type);
						break;
					case 9:
						System.out.println("Display A/Cs  sorted by accno nos (asc)");
						Collections.sort(AccountList);
						BankAccountMethods.displayAccountDetails(AccountList);

						break;	
					case 10:
						System.out.println("Display A/Cs  sorted by balance (desc)");
						Collections.sort(AccountList,new BankClassBalanceComparator());	
						BankAccountMethods.displayAccountDetails(AccountList);

						break;
					case 11: 
						System.out.println("sort acct details as per asc order of dob");
						Collections.sort(AccountList,new BankClassDOBComparator());
						BankAccountMethods.displayAccountDetails(AccountList);
						break;
					case 12:
						System.out.println("sort acct details as per asc order of dob n balance(asc)");
						Collections.sort(AccountList,new BankClassDobAndBalanaceComparator());
						BankAccountMethods.displayAccountDetails(AccountList);
						break;
					case 13:
						System.out.println("sort acct details as per asc order of dob n balance(desc)");
						Collections.sort(AccountList,new BankAccountDobBalanceDescComparator());
						BankAccountMethods.displayAccountDetails(AccountList);
						break;
					case 0:
						exit = true;
						break;
					default:
		                  System.out.println("Invalid choice. Please enter a valid option.");
		                  break;
					}
					}
					
				
				catch(Exception e) {
					System.out.println(e.getMessage());
				}
		}		
		
	}

	}
}
