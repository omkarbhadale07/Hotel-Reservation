package com.ts.hotelreservation.dao;

import java.util.ArrayList;
import java.util.Date;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.ts.hotelreservation.model.AddRooms;


public interface AddRoomsDAO extends JpaRepository<AddRooms, String> {
	
	@Query(value = "SELECT * from add_rooms ad WHERE ad.room_type=?1", nativeQuery = true)
	ArrayList<AddRooms> findByRoomType(String roomType);
	
	@Query(value = "SELECT * from add_rooms ad WHERE ad.room_no=?1", nativeQuery = true)
	AddRooms findByRoomNo(String roomNo);
	
	@Query(value = "SELECT * from add_rooms ad WHERE ad.capacity=?1", nativeQuery = true)
	AddRooms findByCapacity(String capacity);
	
	@Query(value = "select * from add_rooms where date between 'StartDate=?1' and 'EndDate=?2' ", nativeQuery = true)
	ArrayList<AddRooms> findByDate(String StartDate,String EndDate);
	
	@Query(value = "SELECT room_no,room_type from add_rooms ad WHERE ad.availability=?1", nativeQuery = true)
	AddRooms findByRoomavAilability(String availability);

}
