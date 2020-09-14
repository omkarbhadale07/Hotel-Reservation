package com.ts.hotelreservation.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.ts.hotelreservation.model.AdminSession;

public interface AdminSessionDAO extends JpaRepository<AdminSession, String> {

	@Query(value = "SELECT * from admin_session ad WHERE ad.session_token= ?1", nativeQuery = true)
	AdminSession findBysessionToken (String sessionToken);
}
