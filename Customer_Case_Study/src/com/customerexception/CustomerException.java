package com.customerexception;

@SuppressWarnings("serial")
public class CustomerException extends Exception {
	public CustomerException(String errmsg){
		super(errmsg);
	}
	
}
