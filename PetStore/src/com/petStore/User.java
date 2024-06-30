package com.petStore;

import java.util.List;

import com.petStore.enums.Utype;
import com.petStore.exception.PetException;

public class User {

	private String email;
	private String pass;
	public static boolean authorized = false;
	public static Utype utype; 

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPass() {
		return pass;
	}

	public void setPass(String pass) {
		this.pass = pass;
	}

	@Override
	public String toString() {
		return "User [email=" + email + ", pass=" + pass +" Utype= "+utype+ "]";
	}

	public User(String email, String pass,Utype utype) {
		super();
		this.email = email;
		this.pass = pass;
		this.utype=utype;
	}

	public User(String email,Utype utype) {
		super();
		this.email = email;
		this.utype=utype;
	}
	public static boolean isAuthorized() {
		return authorized;
	}

	public static void setAuthorized(boolean authorized) {
		User.authorized = authorized;
	}

	public static Utype getUtype() {
		return utype;
	}

	public static void setUtype(Utype utype) {
		User.utype = utype;
	}

	public User() {
		super();
		// TODO Auto-generated constructor stub
	}

	/*public boolean equals(Object o) {
		if (o instanceof User) {
			User u = (User) o;
			return this.getEmail().equals(u.getEmail());
		}
		return false;
	}*/

	public boolean equals(Object o) {
		if (o instanceof User) {
			User u = (User) o;
			return this.getEmail().equals(u.getEmail()) && this.getUtype().equals(u.getUtype());
		}
		return false;
	}
	
	public static boolean login(User user, List<User> userList) throws PetException {
//		for (User u : userList) {
//			if ((u.getEmail().equals(user.getEmail())) && (u.getPass().equals(user.getPass()))
//				&& (u.getUtype().equals(user.getUtype()))) {
//				System.out.println(user.getEmail() +" "+user.getPass());
//				utype=user.getUtype();
//				return authorized = true;
//			}
//		}
//		return authorized;
		User u1=new User(user.getEmail(),user.getUtype());
		if(userList.contains(u1))
			return authorized = true;
		return authorized ;

	}
}
