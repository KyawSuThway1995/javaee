package com.excel.vo;

import java.util.Date;

public class Employee {

	private String name;
	private String email;
	private Date dob;
	private String address;

	public Employee() {
		super();
	}

	public Employee(String name, String email, Date dob, String address) {
		super();
		this.name = name;
		this.email = email;
		this.dob = dob;
		this.address = address;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public Date getDob() {
		return dob;
	}

	public void setDob(Date dob) {
		this.dob = dob;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	@Override
	public String toString() {
		return "Employee [name=" + name + ", email=" + email + ", dob=" + dob + ", address=" + address + "]";
	}
	
	

}
