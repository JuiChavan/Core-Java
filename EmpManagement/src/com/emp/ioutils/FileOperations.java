package com.emp.ioutils;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.List;

import com.emp.Employee;

public class FileOperations {

	
	public static void WriteFile(String filenm,List<Employee> epmlist) throws FileNotFoundException, IOException {
		try(ObjectOutputStream out=new ObjectOutputStream(new FileOutputStream(filenm)) ){
			System.out.println("writing list into file "+filenm);
			out.writeObject(epmlist);
			System.out.println("w done");
		}
	}
	
	public static List<Employee> ReadFile(String filenm) throws FileNotFoundException, IOException, ClassNotFoundException {
		try(ObjectInputStream in=new ObjectInputStream(new FileInputStream(filenm) )){
			System.out.println("reading list into file "+filenm);
			return (List<Employee>) in.readObject();
		}
	}
}
