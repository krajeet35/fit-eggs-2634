package com.fw19_0497_testcases;

import java.util.Scanner;

import com.fw19_0497.dao.StudentDao;
import com.fw19_0497.dao.StudentDaoImpl;
import com.fw19_0497.exceptions.StudentException;
import com.fw19_0497.model.Student;

public class RegisterStudent {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		System.out.println("Enter student name: ");
		String name=sc.next();
		
		System.out.println("Enter student Address: ");
		String address=sc.next();
		
		System.out.println("Enter student Email: ");
		String email=sc.next();
		
		System.out.println("Enter student Password: ");
		String password=sc.next();
		
		Student student = new Student();
		student.setName(name);
		student.setAddress(address);
		student.setEmail(email);
		student.setPassword(password);
		
		StudentDao dao = new StudentDaoImpl();
		
		try {
			String result = dao.registerStudent(student);
			System.out.println(result);
			
		} catch (StudentException e) {
			System.out.println(e.getMessage());
		}

	}

}
