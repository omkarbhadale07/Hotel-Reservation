package com.ts.hotelreservation.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.ts.hotelreservation.model.RoomType;

public interface RoomTypeDao extends JpaRepository<RoomType	, String> {

}
