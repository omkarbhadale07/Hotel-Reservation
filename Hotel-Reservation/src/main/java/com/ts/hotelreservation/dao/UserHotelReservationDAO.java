package com.ts.hotelreservation.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.ts.hotelreservation.model.UserHotelReservations;

public interface UserHotelReservationDAO extends JpaRepository<UserHotelReservations, String> {

	@Query(value = "SELECT * from user_hotel_reservations ad WHERE ad.user_id= ?1", nativeQuery = true)
	UserHotelReservations findbyUserId (String userId);
}
