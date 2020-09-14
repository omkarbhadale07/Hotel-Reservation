package com.ts.hotelreservation.model;

import javax.persistence.*;

@Entity
public class Admin {

	@Id
	private String Id;
	private String name;
	
	@Column(unique = true)
	private String emailId;
	private String password;
	public String getId() {
		return Id;
	}
	public void setId(String id) {
		Id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getEmailId() {
		return emailId;
	}
	public void setEmailId(String emailId) {
		this.emailId = emailId;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	@Override
	public String toString() {
		return "Admin [Id=" + Id + ", name=" + name + ", emailId=" + emailId + ", password=" + password + "]";
	}
	
	
}
