package com.fw19_0497.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.fw19_0497.exceptions.CourseException;
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

@Override
public String courseEnrollment(int roll, int cid) throws StudentException, CourseException {
	String message= "Not Erolled....!";
	
	try(Connection conn= DBUtil.provideConnection()) {
		
		PreparedStatement ps1= conn.prepareStatement("select * from student where roll =?");
		ps1.setInt(1, roll);
		ResultSet rs = ps1.executeQuery();
		if(rs.next()) {
			PreparedStatement ps2= conn.prepareStatement("select * from course where cid =?");
			ps2.setInt(1, cid);
			ResultSet rs2= ps2.executeQuery();
			if(rs2.next()) {
				PreparedStatement ps3= conn.prepareStatement("insert into student_course values(?,?)");
				ps3.setInt(1, cid);
				ps3.setInt(2, roll);
				int x=ps3.executeUpdate();
				if(x>0) {
					message= "Student enrolled successfully..";
				}
			}
			else {
				throw new CourseException("Invalid COurse Id: "+cid);
			}
		}
		
	} catch (SQLException e) {
		e.printStackTrace();
		throw new CourseException(e.getMessage());
	}
	
	return message;
   }
}
