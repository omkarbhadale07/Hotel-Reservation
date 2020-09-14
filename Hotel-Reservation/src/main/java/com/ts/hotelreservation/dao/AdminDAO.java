package com.ts.hotelreservation.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.ts.hotelreservation.model.Admin;

public interface AdminDAO extends JpaRepository<Admin, String> {

	@Query(value = "SELECT * from admin ad WHERE ad.id=?1", nativeQuery = true)
	Admin finAdminById(String Id);
	
	@Query(value = "SELECT * from admin ad WHERE ad.email_id=?1 AND ad.password=?2 ", nativeQuery = true)
    Admin loginAdmin(final String emailId, final String password);
}
