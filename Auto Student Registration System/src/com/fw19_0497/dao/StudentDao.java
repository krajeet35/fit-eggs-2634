package com.fw19_0497.dao;

import com.fw19_0497.exceptions.CourseException;
import com.fw19_0497.exceptions.StudentException;
import com.fw19_0497.model.Student;

public interface StudentDao {
	
	public String registerStudent(Student student) throws StudentException;
	public Student logIn(String username, String password) throws StudentException;
	
	public String courseEnrollment(int roll, int cid) throws StudentException,CourseException;
	
	
	
}
