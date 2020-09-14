package com.ts.hotelreservation.service;

import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ts.hotelreservation.dao.AdminDAO;
import com.ts.hotelreservation.dao.AdminSessionDAO;
import com.ts.hotelreservation.exceptions.*;
import com.ts.hotelreservation.exceptions.WrongLoginCredentials;
import com.ts.hotelreservation.model.Admin;
import com.ts.hotelreservation.model.AdminSession;

@Service
public class AdminServices {

	@Autowired
	AdminDAO adminDao;
	
	@Autowired 
	AdminSessionDAO adminSessionDAO;
	
	public AdminSession LoginAdmin(final Admin admin) throws WrongLoginCredentials
	{
		AdminSession adminSession = new AdminSession();
		AdminSession session = new AdminSession();
		System.out.println(admin.getEmailId()+" "+admin.getPassword());
		Admin admin1 = adminDao.loginAdmin(admin.getEmailId(),admin.getPassword());
		if(admin1!=null)
		{
			adminSession.setId(UUID.randomUUID().toString());
			adminSession.setAdminId(admin1.getId());
			adminSession.setName(admin1.getName());
			adminSession.setSessionToken(UUID.randomUUID().toString());
			
			session = adminSessionDAO.save(adminSession);
		}
		return session;
	}
	
}
