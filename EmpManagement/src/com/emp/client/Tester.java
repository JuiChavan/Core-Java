package com.emp.client;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.Scanner;

import com.emp.Employee;
import com.emp.enums.Emp_Type;
import com.emp.exception.EmpException;
import com.emp.ioutils.FileOperations;
import com.emp.utils.EmpUtils;


public class Tester {
	public static void main(String args[]) {
		try (Scanner sc = new Scanner(System.in)) {
			boolean exit = false;
			List<Employee> empList = new ArrayList<>();
			/*
			 * String name, String date_of_joining, double phone_Number, String
			 * aadhaar_number, double sal, String etype
			 */
			LocalDate d1 = LocalDate.parse("2000-02-02");
			LocalDate d2 = LocalDate.parse("2000-02-01");
			LocalDate d3 = LocalDate.parse("2000-05-02");
			LocalDate d4 = LocalDate.parse("2002-02-02");

			empList.add(new Employee("a", d1, "1234577890", "112233445566", 725000, Emp_Type.FTE));
			empList.add(new Employee("b", d2, "1234577880", "112233445577", 525000, Emp_Type.FTE));
			empList.add(new Employee("c", d3, "1234577870", "112233445588", 425000, Emp_Type.PTE));
			empList.add(new Employee("d", d4, "1234577860", "112233445599", 325000, Emp_Type.PTE));
			while (!exit) {
				try {
					System.out.println("1.Add full time employee\r\n" + "2.Add part time employee\r\n"
							+ "3.Delete an employee by Emp Id\r\n" + "4.Search employee details by Aadhaar number\r\n"
							+ "5.Display all employee details\r\n"
							+ "6.Display all employee details sorted by date of joining\r\n"
							+ "7.write all employee details into file from list\r\n"
							+ "8.read all employee details into list from file\r\n"
							+ "0.Exit");

					switch (sc.nextInt()) {
					case 1:
						System.out.println("add FTE emp");
						/*
						 * String name, String date_of_joining, String phone_Number, String
						 * aadhaar_number, double sal, String e_type, List<Employee> empList
						 */
						System.out.println(
								"String name, String date_of_joining, String phone_Number, String aadhaar_number,\r\n"
										+ "			double sal, String e_type");
						Employee e1 = EmpUtils.addEmp(sc.next(), sc.next(), sc.next(), sc.next(), sc.nextDouble(),
								Emp_Type.FTE, empList);
						if (e1 == null) {
							throw new EmpException("Error in adding emp");
						}
						empList.add(e1);
						break;
					case 2:
						System.out.println("add FTE emp");
						/*
						 * String name, String date_of_joining, String phone_Number, String
						 * aadhaar_number, double sal, String e_type, List<Employee> empList
						 */
						System.out.println(
								"String name, String date_of_joining, String phone_Number, String aadhaar_number,\r\n"
										+ "			double sal, String e_type");
						Employee e2 = EmpUtils.addEmp(sc.next(), sc.next(), sc.next(), sc.next(), sc.nextDouble(),
								Emp_Type.PTE, empList);
						if (e2 == null) {
							throw new EmpException("Error in adding emp");
						}
						empList.add(e2);
						break;
					case 3:
						System.out.println("Delete an employee by Emp Id : ");
						if (!EmpUtils.deleteEmp(sc.nextInt(), empList)) {
							throw new EmpException("id not found");
						}
						System.out.println("emp deleted with ");
						break;
					case 4:
						System.out.println("Search employee details by Aadhaar number");
						Employee e = EmpUtils.getEmpByAadhar(sc.next(), empList);
						if (e == null) {
							throw new EmpException("id not found");
						}
						System.out.println("emp info : " + e);
						break;

					case 5:
						System.out.println("all  emp");
						empList.forEach(s->System.out.println(s));
						break;
					case 6:
						System.out.println("Display all employee details sorted by date of joining");
						Comparator<Employee> comp=(o1,o2)->o1.getDate_of_joining()
								.compareTo(o2.getDate_of_joining());
						Collections.sort(empList,comp);
						empList.forEach(s->System.out.println(s));
						break;
						
					case 7:
						System.out.println("enter file name to write data");
						FileOperations.WriteFile(sc.next(),empList);
						break;
					case 8:
						System.out.println("enter file name to retrive data");
						List<Employee> empList1=FileOperations.ReadFile(sc.next());
						empList1.forEach(s->System.out.println(s));
						break;
					case 0:
						exit=true;
						break;
					}
				} catch (Exception e) {
					System.out.println(e.getMessage());
				}
			}
		}
	}
}
