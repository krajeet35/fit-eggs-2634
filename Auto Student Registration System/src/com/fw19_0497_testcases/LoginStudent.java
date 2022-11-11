package com.fw19_0497_testcases;

import java.util.Scanner;

import com.fw19_0497.dao.StudentDao;
import com.fw19_0497.dao.StudentDaoImpl;
import com.fw19_0497.exceptions.StudentException;
import com.fw19_0497.model.Student;

public class LoginStudent {
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		System.out.println("Enter Student email/username: ");
		String name = sc.next();
		
		System.out.println("Enter Student password: ");
		String password= sc.next();
		
		StudentDao dao = new StudentDaoImpl();
		try {
			Student student= dao.logIn(name,password);
			System.out.println("Welcome "+student.getName());
			
		} catch (StudentException e) {
			
			e.printStackTrace();
			System.out.println(e.getMessage());
		}
	}

}
