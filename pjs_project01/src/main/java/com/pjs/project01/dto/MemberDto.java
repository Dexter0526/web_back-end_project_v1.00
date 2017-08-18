package com.pjs.project01.dto;

public class MemberDto {

	private String name;
	private String userid;
	private String pwd;
	private String email;
	private String phone;
	
	public MemberDto() {
		// TODO Auto-generated constructor stub
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getUserid() {
		return userid;
	}

	public void setUserid(String userid) {
		this.userid = userid;
	}

	public String getPwd() {
		return pwd;
	}

	public void setPwd(String pwd) {
		this.pwd = pwd;
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

	public MemberDto(String name, String userid, String pwd, String email, String phone) {
		super();
		this.name = name;
		this.userid = userid;
		this.pwd = pwd;
		this.email = email;
		this.phone = phone;
	}
	
	
	
}
