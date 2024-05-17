package com.bankaccount;

public enum BankAccountType {

	SAVINGS(10000), CURRENT(5000), FD(50000), 
	LOAN(25000), DMAT(40000), NRE(150000);
	
	private double minbal=0;
	
	BankAccountType(double minbal) {
		this.minbal=minbal;
	}

	public double getMinbal() {
		return minbal;
	}

	public void setMinbal(double minbal) {
		this.minbal = minbal;
	}
	
	
	
	
}
