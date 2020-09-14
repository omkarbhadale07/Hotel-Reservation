package com.ts.hotelreservation.model;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class RoomType {
	
	@Id
	private String id;
	private String roomType;
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
	@Override
	public String toString() {
		return "roomType [id=" + id + ", roomType=" + roomType + "]";
	}
	

}
