package com.ts.hotelreservation.service;

import java.util.ArrayList;
import java.util.Date;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ts.hotelreservation.dao.AddRoomsDAO;
import com.ts.hotelreservation.dao.AdminSessionDAO;
import com.ts.hotelreservation.dao.UserSessionDAO;
import com.ts.hotelreservation.exceptions.WrongDetails;
import com.ts.hotelreservation.model.AddRooms;
import com.ts.hotelreservation.model.AdminSession;
import com.ts.hotelreservation.model.UserSession;

@Service
public class AddRoomsService {

	@Autowired
	AddRoomsDAO addRoomsDAO;
	
	@Autowired
	UserSessionDAO userSessionDAO;
	
	@Autowired
	AdminSessionDAO adminSessionDAO;
	
	public AddRooms addRoom (final AddRooms addRooms,String sessionToken) throws WrongDetails
	{	
		AddRooms roomData = new AddRooms();
		AdminSession adminSession = adminSessionDAO.findBysessionToken(sessionToken);
		if(adminSession!=null)
		{
			addRooms.setId(UUID.randomUUID().toString());
			addRooms.setAvailability("available");
			roomData = addRoomsDAO.save(addRooms);
		}
		return roomData;
	}
	
	public ArrayList<AddRooms> showAllRooms() {
		ArrayList<AddRooms> addRooms = (ArrayList<AddRooms>) addRoomsDAO.findAll();
		return addRooms;
	}

	public ArrayList<AddRooms> findRoomByType(final String roomType) throws WrongDetails
	{
		ArrayList<AddRooms> rooms = addRoomsDAO.findByRoomType(roomType);
		return rooms;
	}
	
	public AddRooms findByRoomNo(final String roomNo) throws WrongDetails
	{
		AddRooms rooms = addRoomsDAO.findByRoomNo(roomNo);
		return rooms;
	}
	
	
	public Object deleteRoom(String id) 
	{
		addRoomsDAO.deleteById(id);
		return "success";
	}
	
	public AddRooms userRegisterRoom(final String roomNo) throws WrongDetails
	{
		AddRooms addRooms= new AddRooms();
		AddRooms rooms = addRoomsDAO.findByRoomNo(roomNo);
		if(rooms!=null)
		{
			rooms.setAvailability("booked");
			addRooms = addRoomsDAO.save(rooms);
			
		}
		return addRooms;
	}
	
	public AddRooms findByCapacity(final String capacity)throws WrongDetails
	{
		AddRooms rooms = addRoomsDAO.findByCapacity(capacity);
		return rooms;
	}
	
	public ArrayList<AddRooms> findRoomByDate(final String StartDate,final String EndDate)throws WrongDetails
	{
		System.out.println(StartDate +" "+ EndDate);
		ArrayList<AddRooms> rooms = addRoomsDAO.findByDate(StartDate,EndDate);
		System.out.println(rooms);
		return rooms;
	}
	
	public AddRooms setRoomAvailable(final String roomNo) throws WrongDetails
	{
		AddRooms addRooms= new AddRooms();
		AddRooms rooms = addRoomsDAO.findByRoomNo(roomNo);
		if(rooms!=null)
		{
			rooms.setAvailability("available");
			addRooms = addRoomsDAO.save(rooms);
			
		}
		return addRooms;
	}
	
	public AddRooms getAvailableRooms(final String availability) throws WrongDetails
	{
		AddRooms rooms = addRoomsDAO.findByRoomavAilability(availability);	
		return rooms;
	}
	
	
	
}
