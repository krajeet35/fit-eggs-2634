package com.fw19_0497.dao;

import java.util.List;

import com.fw19_0497.exceptions.CourseException;
import com.fw19_0497.model.Student;
import com.fw19_0497.model.StudentCourse;

public interface CourseDao {
	
	public List<StudentCourse> getAllStudentByCourse(String cname) throws CourseException;

}
