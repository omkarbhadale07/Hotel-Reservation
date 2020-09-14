package com.ts.hotelreservation.service;

import java.util.ArrayList;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ts.hotelreservation.dao.AdminSessionDAO;
import com.ts.hotelreservation.dao.UserDAO;
import com.ts.hotelreservation.dao.UserSessionDAO;
import com.ts.hotelreservation.exceptions.AdminNotLoggedIn;
import com.ts.hotelreservation.exceptions.WrongLoginCredentials;
import com.ts.hotelreservation.exceptions.userDetailsAreWrong;
import com.ts.hotelreservation.model.AdminSession;
import com.ts.hotelreservation.model.User;
import com.ts.hotelreservation.model.UserSession;

@Service
public class UserService {

	@Autowired
	UserDAO userDAO;

	@Autowired
	UserSessionDAO userSessionDAO;

	@Autowired
	AdminSessionDAO adminSessionDAO;

	public User registerUser(final User user) throws userDetailsAreWrong {

		User userData = new User();

		user.setId(UUID.randomUUID().toString());
		userData = userDAO.save(user);
		return userData;
	}

	public UserSession loginUser(final User user) throws WrongLoginCredentials {
		UserSession userSessionData = new UserSession();
		UserSession userSession = new UserSession();

		User loginUser = userDAO.loginUser(user.getEmailId(), user.getPassword());
		if (loginUser != null) {

			userSession.setId(UUID.randomUUID().toString());
			userSession.setSessionToken(UUID.randomUUID().toString());
			userSession.setName(loginUser.getName());
			userSession.setUserId(loginUser.getId());

			userSessionData = userSessionDAO.save(userSession);
		}
		return userSessionData;
	}

	public ArrayList<User> showAllUsers(String sessionToken) throws AdminNotLoggedIn {
		ArrayList<User> userRegistration = new ArrayList<User>();
		AdminSession adminSession = adminSessionDAO.findBysessionToken(sessionToken);
		if (adminSession != null) {
			userRegistration = (ArrayList<User>) userDAO.findAll();

		}
		return userRegistration;
	}

	public Object deleteUser(String id) {
		userDAO.deleteById(id);
		return "success";
	}

}
