package com.fw19_0497.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.fw19_0497.exceptions.StudentException;
import com.fw19_0497.model.Student;
import com.fw19_0497.utility.DBUtil;

public class StudentDaoImpl implements StudentDao {
   @Override
   public String registerStudent(Student student) throws StudentException {
	   String result="Not inserted..";
	   try(Connection conn= DBUtil.provideConnection()) {
		   PreparedStatement ps= conn.prepareStatement("insert into student(name,address,email,password) values(?,?,?,?)");
		   ps.setString(1, student.getName());
		   ps.setString(2, student.getAddress());
		   ps.setString(3, student.getEmail());
		   ps.setString(4, student.getPassword());
		   
		   int x = ps.executeUpdate();
		   if(x>0) {
			   result="Student Registered Successfully..";
		   }
		  
		   
		
	} catch (SQLException e) {
		e.printStackTrace();
		throw new StudentException(e.getMessage());
	}
	   return result;
   }

@Override
public Student logIn(String username, String password) throws StudentException {
	Student student = null;
	try(Connection conn =DBUtil.provideConnection()) {
		
		PreparedStatement ps=  conn.prepareStatement("select * from student where email=? AND password=?");
		ps.setString(1,username);
		ps.setString(2, password);
		
		ResultSet rs = ps.executeQuery();
		if(rs.next()) {
			student = new Student(rs.getInt("roll"),rs.getString("name"), rs.getString("address"),rs.getString("email"), rs.getString("password"));
		}
		else {
			throw new StudentException("Invalid Username or password..");
		}
		
	} catch (SQLException e) {
		e.printStackTrace();
		throw new StudentException(e.getMessage());
	}
	return student;
  }
}
