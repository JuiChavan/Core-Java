package com.emp.utils;

import java.time.LocalDate;
import java.util.List;

import com.emp.Employee;
import com.emp.enums.Emp_Type;
import com.emp.exception.EmpException;

public class EmpUtils {
	public static Employee addEmp(String name, String date_of_joining, String phone_Number, String aadhaar_number,
			double sal, Emp_Type etype, List<Employee> empList) throws EmpException {

		Employee e = null;
		Employee es = new Employee(aadhaar_number);
		boolean dupliChk = empList.contains(es);

		if (dupliChk == true) {
			throw new EmpException("Already exists");
		}
		boolean phoneChk = (phone_Number).matches("^[0-9]*$");
		if (phoneChk == false) {
			throw new EmpException("Invalid phone num");
		}
		boolean aadharChk = (aadhaar_number).matches("\\d{12}");
		if (aadharChk == false) {
			throw new EmpException("Invalid aadhar num");
		}
		int len1 = aadhaar_number.length();
		if (len1 != 12) {
			throw new EmpException("Invalid aadhar num length ");
		}
		int len2 = phone_Number.length();
		if (len2 != 10) {
			throw new EmpException("Invalid phone num length ");
		}
		LocalDate d = LocalDate.parse(date_of_joining);
		return e = new Employee(name, d, phone_Number, aadhaar_number, sal, etype);

	}

	public static boolean deleteEmp(int id, List<Employee> emplist) {
		Employee e1 = null;
		for (Employee e : emplist) {
			if (e.getId() == id) {
				e1 = e;
				return emplist.remove(e1);
			}
		}
		return false;
	}

	public static Employee getEmpByAadhar(String aid, List<Employee> emplist) {
		Employee e = null;
		for (Employee e1 : emplist) {
			if (e1.getAadhaar_number().equals(aid)) {
				e = e1;
				return e;
			}
		}
		return e;
	}

}
