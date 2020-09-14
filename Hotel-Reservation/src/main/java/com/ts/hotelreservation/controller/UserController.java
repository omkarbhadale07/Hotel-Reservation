package com.ts.hotelreservation.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RestController;


import com.ts.hotelreservation.exceptions.*;
import com.ts.hotelreservation.model.Response;
import com.ts.hotelreservation.model.User;
import com.ts.hotelreservation.service.UserService;
import com.ts.hotelreservation.utils.StatusCodes;

@RestController
public class UserController {

	@Autowired
	UserService userService;
	
	@PostMapping("/registerUser")
	public Response registerUser(@RequestBody User user) {

		Response response = new Response();
		try {
			response.setResultSet(userService.registerUser(user));
			response.setOperationStatus(StatusCodes.OPERATIONSUCCESSFULL);

		} catch (userDetailsAreWrong e) {
			response.setOperationStatus(StatusCodes.WRONGLOGINCREDENTIALS);
		} catch (Exception e) {
			response.setOperationStatus(StatusCodes.UNKNOWNERROR);
			e.printStackTrace();

		}

		return response;
	}
	
	@PostMapping("/loginUser")
	public Response loginUser(@RequestBody User user) {

		Response response = new Response();
		try {
			response.setResultSet(userService.loginUser(user));
			response.setOperationStatus(StatusCodes.OPERATIONSUCCESSFULL);

		} catch (WrongLoginCredentials e) {
			response.setOperationStatus(StatusCodes.WRONGLOGINCREDENTIALS);
		} catch (Exception e) {
			response.setOperationStatus(StatusCodes.UNKNOWNERROR);
			e.printStackTrace();

		}

		return response;
	}
	
	@PostMapping("/findAllUsers")
	public Response findAllUsers(@RequestHeader String sessionToken) {

		Response response = new Response();
		try {
			response.setResultSet(userService.showAllUsers(sessionToken));
			response.setOperationStatus(StatusCodes.OPERATIONSUCCESSFULL);

		} catch (AdminNotLoggedIn e) {
			response.setOperationStatus(StatusCodes.WRONGLOGINCREDENTIALS);
		} catch (Exception e) {
			response.setOperationStatus(StatusCodes.UNKNOWNERROR);
			e.printStackTrace();

		}

		return response;
	}
	
	@PostMapping("/deleteUserById")
	public Response delete(@RequestHeader String id) {

		Response response = new Response();
		try {
			response.setResultSet(userService.deleteUser(id));
			response.setOperationStatus(StatusCodes.OPERATIONSUCCESSFULL);

		} catch (Exception e) {
			response.setOperationStatus(StatusCodes.UNKNOWNERROR);
			e.printStackTrace();

		}

		return response;
	}
	
	

}
