package com.ts.hotelreservation.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.ts.hotelreservation.model.User;

public interface UserDAO extends JpaRepository<User, String> {
	
	@Query(value = "SELECT * from user ad WHERE ad.email_id=?1 AND ad.password=?2 ", nativeQuery = true)
    User loginUser(final String emailId, final String password);
}