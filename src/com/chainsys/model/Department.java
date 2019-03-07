package com.chainsys.model;

public class Department {
	private int dept_id;
	private String name;
	private String hod;

	@Override
	public String toString() {
		return "Department [dept_id=" + dept_id + ", name=" + name + ", hod="
				+ hod + "]";
	}

	public int getDept_id() {
		return dept_id;
	}

	public void setDept_id(int dept_id) {
		this.dept_id = dept_id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getHod() {
		return hod;
	}

	public void setHod(String hod) {
		this.hod = hod;
	}

}
