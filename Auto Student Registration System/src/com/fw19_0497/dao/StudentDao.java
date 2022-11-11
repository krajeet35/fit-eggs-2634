package com.fw19_0497.dao;

import com.fw19_0497.exceptions.StudentException;
import com.fw19_0497.model.Student;

public interface StudentDao {
	
	public String registerStudent(Student student) throws StudentException;

}
