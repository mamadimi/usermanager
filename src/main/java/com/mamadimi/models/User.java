package com.mamadimi.models;

public class User {
	
	private long id; 
	
	public User() {}

	public User(String fullName, String email, String phone, String company, String password, String passConfirm) {
		super();
		this.fullName = fullName;
		this.email = email;
		this.phone = phone;
		this.company = company;
		this.password = password;
		this.passConfirm = passConfirm;
	}

	private String fullName;
	
	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	private String email;
	
	private String phone;
	
	private String company;
	
	private String password;
	
	private String passConfirm;

	public String getPassConfirm() {
		return passConfirm;
	}

	public void setPassConfirm(String passConfirm) {
		this.passConfirm = passConfirm;
	}

	public String getFullName() {
		return fullName;
	}

	public void setFullName(String fullName) {
		this.fullName = fullName;
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

	public String getCompany() {
		return company;
	}

	public void setCompany(String company) {
		this.company = company;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	@Override
	public String toString() {
		// TODO Auto-generated method stub
		return email + " " + fullName + " " + phone + " " + company + " " + password ;
	}
	
	

}
