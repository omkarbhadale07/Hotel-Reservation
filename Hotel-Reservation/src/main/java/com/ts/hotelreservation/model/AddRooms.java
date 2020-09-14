package com.ts.hotelreservation.model;

import java.time.LocalDateTime;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import org.hibernate.annotations.CreationTimestamp;


@Entity
public class AddRooms {
	@Id
	private String id;
	
	private int roomNo;
	private String roomType;
	
	private String capacity;
	
	@Column(name = "date", updatable = false)
    @CreationTimestamp
    @Temporal(TemporalType.DATE)
    private Date date;
	
	private String availability;

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getRoomType() {
		return roomType;
	}

	public void setRoomType(String roomType) {
		this.roomType = roomType;
	}

	public String getCapacity() {
		return capacity;
	}

	public void setCapacity(String capacity) {
		this.capacity = capacity;
	}

	

	public int getRoomNo() {
		return roomNo;
	}

	public void setRoomNo(int roomNo) {
		this.roomNo = roomNo;
	}	

	public Date getDate() {
		return date;
	}

	public void setDate(Date date) {
		this.date = date;
	}

	public String getAvailability() {
		return availability;
	}

	public void setAvailability(String availability) {
		this.availability = availability;
	}

	@Override
	public String toString() {
		return "AddRooms [id=" + id + ", roomNo=" + roomNo + ", roomType=" + roomType + ", capacity=" + capacity
				+ ", date=" + date + ", availability=" + availability + "]";
	}

	
	
}
