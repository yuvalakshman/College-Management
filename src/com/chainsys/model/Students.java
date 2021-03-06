package com.chainsys.model;

public class Students {
	private int roll;
	private String password;
	private String name;
	private float attendance;
	private float cgpa;
	private String batch;
	private String mail;
	private int id;
	private String gender;
	public String getGender() {
		return gender;
	}

	public void setGender(String gender) {
		this.gender = gender;
	}

	Department department;
	

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}


	public Department getDepartment() {
		return department;
	}

	public void setDepartment(Department department) {
		this.department = department;
	}

	@Override
	public String toString() {
		return "Students [roll=" + roll + ", password=" + password + ", name="
				+ name + ", attendance=" + attendance + ", cgpa=" + cgpa
				+ ", batch=" + batch + ", mail=" + mail + ", id=" + id
				+ ", gender=" + gender + ", department=" + department + "]";
	}

	public int getRoll() {
		return roll;
	}

	public void setRoll(int roll) {
		this.roll = roll;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public float getAttendance() {
		return attendance;
	}

	public void setAttendance(float attendance) {
		this.attendance = attendance;
	}

	public float getCgpa() {
		return cgpa;
	}

	public void setCgpa(float cgpa) {
		this.cgpa = cgpa;
	}

	public String getBatch() {
		return batch;
	}

	public void setBatch(String batch) {
		this.batch = batch;
	}

	public String getMail() {
		return mail;
	}

	public void setMail(String mail) {
		this.mail = mail;
	}
}
