package com.ssafy.sample.dto;

public class Emp {
	
	private String empid, fname, email, phone, jobid, deptid;

	public Emp() {}
	
	public Emp(String empid, String fname, String email, String phone, String jobid, String deptid) {
		super();
		this.empid = empid;
		this.fname = fname;
		this.email = email;
		this.phone = phone;
		this.jobid = jobid;
		this.deptid = deptid;
	}

	public String getEmpid() {
		return empid;
	}

	public void setEmpid(String empid) {
		this.empid = empid;
	}

	public String getFname() {
		return fname;
	}

	public void setFname(String fname) {
		this.fname = fname;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	public String getJobid() {
		return jobid;
	}

	public void setJobid(String jobid) {
		this.jobid = jobid;
	}

	public String getDeptid() {
		return deptid;
	}

	public void setDeptid(String deptid) {
		this.deptid = deptid;
	}
	

}
