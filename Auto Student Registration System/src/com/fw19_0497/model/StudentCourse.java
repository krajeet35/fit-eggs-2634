package com.fw19_0497.model;

public class StudentCourse {
	
	private int roll;
	private String sname;
	private String email;
	private String address;
	private String cnanme;
	private String duration;
	
	
	public StudentCourse(int roll, String sname, String email, String address, String cnanme, String duration) {
		super();
		this.roll = roll;
		this.sname = sname;
		this.email = email;
		this.address = address;
		this.cnanme = cnanme;
		this.duration = duration;
	}


	public int getRoll() {
		return roll;
	}


	public void setRoll(int roll) {
		this.roll = roll;
	}


	public String getSname() {
		return sname;
	}


	public void setSname(String sname) {
		this.sname = sname;
	}


	public String getEmail() {
		return email;
	}


	public void setEmail(String email) {
		this.email = email;
	}


	public String getAddress() {
		return address;
	}


	public void setAddress(String address) {
		this.address = address;
	}


	public String getCnanme() {
		return cnanme;
	}


	public void setCnanme(String cnanme) {
		this.cnanme = cnanme;
	}


	public String getDuration() {
		return duration;
	}


	public void setDuration(String duration) {
		this.duration = duration;
	}
	
	

}
