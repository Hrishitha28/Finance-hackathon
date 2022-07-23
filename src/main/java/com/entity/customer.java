package com.entity;

import java.io.Serializable;

public class customer implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	String fname;
	String lname;
	String mname;
	String nation;
	String email;
	String password;
	String femail;
	public String getFemail() {
		return femail;
	}
	public String setFemail(String femail) {
		this.femail = femail;
		return femail;
	}
	public String getFname() {
		return fname;
	}
	public void setFname(String fname) {
		this.fname = fname;
	}
	public String getLname() {
		return lname;
	}
	public void setLname(String lname) {
		this.lname = lname;
	}
	public String getMname() {
		return mname;
	}
	public void setMname(String mname) {
		this.mname = mname;
	}
	public String getNation() {
		return nation;
	}
	public void setNation(String nation) {
		this.nation = nation;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	
	
}
