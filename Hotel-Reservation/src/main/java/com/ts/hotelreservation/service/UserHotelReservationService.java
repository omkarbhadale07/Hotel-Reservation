package com.ts.hotelreservation.service;

import java.util.ArrayList;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ts.hotelreservation.dao.AdminSessionDAO;
import com.ts.hotelreservation.dao.UserHotelReservationDAO;
import com.ts.hotelreservation.dao.UserSessionDAO;
import com.ts.hotelreservation.exceptions.AdminNotLoggedIn;
import com.ts.hotelreservation.exceptions.CustomerNotLoggedIn;
import com.ts.hotelreservation.exceptions.WrongDetails;
import com.ts.hotelreservation.model.AddRooms;
import com.ts.hotelreservation.model.AdminSession;
import com.ts.hotelreservation.model.UserHotelReservations;
import com.ts.hotelreservation.model.UserSession;

@Service
public class UserHotelReservationService {

	@Autowired
	UserHotelReservationDAO hotelReservationDAO;

	@Autowired
	UserSessionDAO userSessionDAO;

	@Autowired
	AdminSessionDAO adminSessionDAO;
	
	@Autowired
	AddRoomsService addRoomsService;

	public UserHotelReservations RegisterRoom(final UserHotelReservations reservations, final String sessionToken,final String roomNo)
			throws CustomerNotLoggedIn, WrongDetails {
		UserHotelReservations hotelReservations = new UserHotelReservations();
		UserSession session = userSessionDAO.findBysessionToken(sessionToken);
		if (session != null) {
			reservations.setId(UUID.randomUUID().toString());
			reservations.setUserId(session.getUserId());
			AddRooms addrooms = addRoomsService.userRegisterRoom(roomNo); //for room booking purpose
			/*
			 * reservations.setCapacity(addrooms.getCapacity());//capacity will Store
			 * automatically
			 */			
			reservations.setRoomType(addrooms.getRoomType());
			reservations.setRoomNo(addrooms.getRoomNo());
			hotelReservations = hotelReservationDAO.save(reservations);
		}
		return hotelReservations;
	}

	public ArrayList<UserHotelReservations> ShowAllReservations(final String sessionToken) throws AdminNotLoggedIn {
		ArrayList<UserHotelReservations> hotelReservations = new ArrayList<UserHotelReservations>();
		AdminSession adminSession = adminSessionDAO.findBysessionToken(sessionToken);
		if (adminSession != null) {
			hotelReservations = (ArrayList<UserHotelReservations>) hotelReservationDAO.findAll();
		}
		return hotelReservations;
	}
	
	public UserHotelReservations finadByUserId(final String userId  ) throws AdminNotLoggedIn {
		UserHotelReservations hotelReservations = new UserHotelReservations();
		
		hotelReservations =  hotelReservationDAO.findbyUserId(userId);
		
		return hotelReservations;
	}
	

	public Object DeleteReservation(final String id,final String sessionToken,final String roomNo) throws AdminNotLoggedIn, WrongDetails {
		AdminSession adminSession = adminSessionDAO.findBysessionToken(sessionToken);
		if (adminSession != null) {
			  hotelReservationDAO.deleteById(id);
			  addRoomsService.setRoomAvailable(roomNo);
		}
		return "success";
	}
	
	
}
