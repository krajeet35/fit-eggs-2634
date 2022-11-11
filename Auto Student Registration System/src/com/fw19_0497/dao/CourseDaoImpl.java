package com.fw19_0497.dao;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.fw19_0497.exceptions.CourseException;
import com.fw19_0497.model.StudentCourse;
import com.fw19_0497.utility.DBUtil;

public class CourseDaoImpl implements CourseDao {

	@Override
	public List<StudentCourse> getAllStudentByCourse(String cname) throws CourseException {
		
		List<StudentCourse> stc= new ArrayList<>();
		
		try(Connection conn = DBUtil.provideConnection()) {
			
			
			
		} catch (SQLException e) {
			e.printStackTrace();
			throw new CourseException(e.getMessage());
		}
		
		return stc;
		
	}

}
