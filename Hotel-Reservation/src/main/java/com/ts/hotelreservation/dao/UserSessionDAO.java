package com.ts.hotelreservation.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import com.ts.hotelreservation.model.UserSession;

public interface UserSessionDAO extends JpaRepository<UserSession, String> {

	@Query(value = "SELECT * from user_session ad WHERE ad.session_token= ?1", nativeQuery = true)
	UserSession findBysessionToken (String sessionToken);
}
