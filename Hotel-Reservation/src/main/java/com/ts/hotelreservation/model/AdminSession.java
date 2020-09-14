package com.ts.hotelreservation.model;

import java.time.LocalDateTime;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;

import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

@Entity
public class AdminSession {

	@Id
    private String Id;
    private String sessionToken;
    private String AdminId;
    private String name;
    @Column(name = "createdOn", updatable = false)
    @CreationTimestamp
    private LocalDateTime createdOn;
    @Column
    @UpdateTimestamp
    private LocalDateTime updatedOn;
	public String getId() {
		return Id;
	}
	public void setId(String id) {
		Id = id;
	}
	
	public String getSessionToken() {
		return sessionToken;
	}
	public void setSessionToken(String sessionToken) {
		this.sessionToken = sessionToken;
	}
	public String getAdminId() {
		return AdminId;
	}
	public void setAdminId(String adminId) {
		AdminId = adminId;
	}
	public LocalDateTime getCreatedOn() {
		return createdOn;
	}
	public void setCreatedOn(LocalDateTime createdOn) {
		this.createdOn = createdOn;
	}
	public LocalDateTime getUpdatedOn() {
		return updatedOn;
	}
	public void setUpdatedOn(LocalDateTime updatedOn) {
		this.updatedOn = updatedOn;
	}
	
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	@Override
	public String toString() {
		return "AdminSession [Id=" + Id + ", sessionToken=" + sessionToken + ", AdminId=" + AdminId + ", name=" + name
				+ ", createdOn=" + createdOn + ", updatedOn=" + updatedOn + "]";
	}
    
}
