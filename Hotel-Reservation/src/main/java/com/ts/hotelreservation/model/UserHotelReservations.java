package com.ts.hotelreservation.model;

import javax.persistence.*;

@Entity
public class UserHotelReservations {

	@Id
	private String id;
	private String userId;
	private String name;
	private String contactNo;
	private String emailId;
	private String checkInDate;
	private String checkOutDate;
	private String capacity;
	private String roomType;
	private int roomNo;

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getUserId() {
		return userId;
	}

	public void setUserId(String userId) {
		this.userId = userId;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getContactNo() {
		return contactNo;
	}

	public void setContactNo(String contactNo) {
		this.contactNo = contactNo;
	}

	public String getEmailId() {
		return emailId;
	}

	public void setEmailId(String emailId) {
		this.emailId = emailId;
	}

	public String getCheckInDate() {
		return checkInDate;
	}

	public void setCheckInDate(String checkInDate) {
		this.checkInDate = checkInDate;
	}

	public String getCheckOutDate() {
		return checkOutDate;
	}

	public void setCheckOutDate(String checkOutDate) {
		this.checkOutDate = checkOutDate;
	}

	public String getCapacity() {
		return capacity;
	}

	public void setCapacity(String capacity) {
		this.capacity = capacity;
	}

	

	public String getRoomType() {
		return roomType;
	}

	public void setRoomType(String roomType) {
		this.roomType = roomType;
	}

	public int getRoomNo() {
		return roomNo;
	}

	public void setRoomNo(int roomNo) {
		this.roomNo = roomNo;
	}

	@Override
	public String toString() {
		return "UserHotelReservations [id=" + id + ", userId=" + userId + ", name=" + name + ", contactNo=" + contactNo
				+ ", emailId=" + emailId + ", checkInDate=" + checkInDate + ", checkOutDate=" + checkOutDate
				+ ", capacity=" + capacity + ", roomType=" + roomType + ", roomNo=" + roomNo + "]";
	}
	
	

}
