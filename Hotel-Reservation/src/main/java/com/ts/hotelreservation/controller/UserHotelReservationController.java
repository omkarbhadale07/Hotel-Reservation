package com.ts.hotelreservation.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RestController;

import com.ts.hotelreservation.exceptions.AdminNotLoggedIn;
import com.ts.hotelreservation.exceptions.CustomerNotLoggedIn;
import com.ts.hotelreservation.exceptions.userDetailsAreWrong;
import com.ts.hotelreservation.model.Response;
import com.ts.hotelreservation.model.User;
import com.ts.hotelreservation.model.UserHotelReservations;
import com.ts.hotelreservation.service.UserHotelReservationService;
import com.ts.hotelreservation.utils.StatusCodes;

@RestController
public class UserHotelReservationController {
	
	@Autowired
	UserHotelReservationService hotelReservationService;
	
	@PostMapping("/registerRoom")
	public Response RegisterRoom(@RequestBody UserHotelReservations hotelReservations,@RequestHeader String sessionToken,@RequestHeader String roomNo) {

		Response response = new Response();
		try {
			response.setResultSet(hotelReservationService.RegisterRoom(hotelReservations, sessionToken,roomNo));
			response.setOperationStatus(StatusCodes.OPERATIONSUCCESSFULL);

		} catch (CustomerNotLoggedIn e) {
			response.setOperationStatus(StatusCodes.WRONGLOGINCREDENTIALS);
		} catch (Exception e) {
			response.setOperationStatus(StatusCodes.UNKNOWNERROR);
			e.printStackTrace();

		}

		return response;
	}
	
	@PostMapping("/ShowAllReservations")
	public Response ShowAllReservations(@RequestHeader String sessionToken) {

		Response response = new Response();
		try {
			response.setResultSet(hotelReservationService.ShowAllReservations(sessionToken));
			response.setOperationStatus(StatusCodes.OPERATIONSUCCESSFULL);

		} catch (AdminNotLoggedIn e) {
			response.setOperationStatus(StatusCodes.WRONGLOGINCREDENTIALS);
		} catch (Exception e) {
			response.setOperationStatus(StatusCodes.UNKNOWNERROR);
			e.printStackTrace();

		}

		return response;
	}

	@PostMapping("/findReservationByUserId")
	public Response findReservationByUserId(@RequestHeader String userId) {

		Response response = new Response();
		try {
			response.setResultSet(hotelReservationService.finadByUserId(userId));
			response.setOperationStatus(StatusCodes.OPERATIONSUCCESSFULL);

		} catch (AdminNotLoggedIn e) {
			response.setOperationStatus(StatusCodes.WRONGLOGINCREDENTIALS);
		} catch (Exception e) {
			response.setOperationStatus(StatusCodes.UNKNOWNERROR);
			e.printStackTrace();

		}

		return response;
	}
	
	@PostMapping("/DeleteReservation")
	public Response DeleteReservation(@RequestHeader String sessionToken,@RequestHeader String id,@RequestHeader String roomNo) {

		Response response = new Response();
		try {
			response.setResultSet(hotelReservationService.DeleteReservation(id,sessionToken,roomNo));
			response.setOperationStatus(StatusCodes.OPERATIONSUCCESSFULL);

		} catch (AdminNotLoggedIn e) {
			response.setOperationStatus(StatusCodes.WRONGLOGINCREDENTIALS);
		} catch (Exception e) {
			response.setOperationStatus(StatusCodes.UNKNOWNERROR);
			e.printStackTrace();
		}
		return response;
	}

}
