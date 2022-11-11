package com.fw19_0497_testcases;

import java.util.Scanner;

import com.fw19_0497.dao.StudentDao;
import com.fw19_0497.dao.StudentDaoImpl;
import com.fw19_0497.exceptions.CourseException;
import com.fw19_0497.exceptions.StudentException;

public class CourseEnroll {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		System.out.println("Enter Student roll: ");
		int roll = sc.nextInt();
		
		System.out.println("Enter Course Id: ");
		int cid= sc.nextInt();
		
		StudentDao  dao =new StudentDaoImpl();
		
		try {
			String result=dao.courseEnrollment(roll, cid);
			System.out.println(result);
		} catch (Exception e) {
			System.out.println(e.getMessage());
		 } 
		
		

	}

}
