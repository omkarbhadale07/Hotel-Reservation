package com.ts.hotelreservation.controller;

import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RestController;

import com.ts.hotelreservation.exceptions.WrongDetails;
import com.ts.hotelreservation.model.AddRooms;
import com.ts.hotelreservation.model.Response;
import com.ts.hotelreservation.service.AddRoomsService;
import com.ts.hotelreservation.utils.StatusCodes;

@RestController
public class AddRoomsController {

	@Autowired
	AddRoomsService addRoomsService;

	@PostMapping("/AddRoom")
	public Response AddRoom(@RequestBody AddRooms addRooms, @RequestHeader String sessionToken) {

		Response response = new Response();
		try {
			response.setResultSet(addRoomsService.addRoom(addRooms, sessionToken));
			response.setOperationStatus(StatusCodes.OPERATIONSUCCESSFULL);

		} catch (WrongDetails e) {
			response.setOperationStatus(StatusCodes.WRONGLOGINCREDENTIALS);
		} catch (Exception e) {
			response.setOperationStatus(StatusCodes.UNKNOWNERROR);
			e.printStackTrace();

		}

		return response;
	}

	@PostMapping("/showAllRooms")
	public Response showAllRooms() {

		Response response = new Response();
		try {
			response.setResultSet(addRoomsService.showAllRooms());
			response.setOperationStatus(StatusCodes.OPERATIONSUCCESSFULL);

		} catch (Exception e) {
			response.setOperationStatus(StatusCodes.UNKNOWNERROR);
			e.printStackTrace();

		}

		return response;
	}

	@PostMapping("/findRoomByType")
	public Response findRoomByType(@RequestHeader String roomType) {
		Response response = new Response();
		try {
			response.setResultSet(addRoomsService.findRoomByType(roomType));
			response.setOperationStatus(StatusCodes.OPERATIONSUCCESSFULL);

		} catch (WrongDetails e) {
			response.setOperationStatus(StatusCodes.WRONGLOGINCREDENTIALS);
		} catch (Exception e) {
			response.setOperationStatus(StatusCodes.UNKNOWNERROR);
			e.printStackTrace();
		}
		return response;
	}
	@PostMapping("/findRoomByDate")
	public Response findRoomByDate(@RequestHeader String StartDate,@RequestHeader String EndDate) {
		Response response = new Response();
		try {
			response.setResultSet(addRoomsService.findRoomByDate(StartDate,EndDate));
			response.setOperationStatus(StatusCodes.OPERATIONSUCCESSFULL);

		} catch (WrongDetails e) {
			response.setOperationStatus(StatusCodes.WRONGLOGINCREDENTIALS);
		} catch (Exception e) {
			response.setOperationStatus(StatusCodes.UNKNOWNERROR);
			e.printStackTrace();
		}
		return response;
	}

	@PostMapping("/findRoomByRoomNo")
	public Response findRoomByRoomNo(@RequestHeader String roomNo) {
		Response response = new Response();
		try {
			response.setResultSet(addRoomsService.findByRoomNo(roomNo));
			response.setOperationStatus(StatusCodes.OPERATIONSUCCESSFULL);

		} catch (WrongDetails e) {
			response.setOperationStatus(StatusCodes.WRONGLOGINCREDENTIALS);
		} catch (Exception e) {
			response.setOperationStatus(StatusCodes.UNKNOWNERROR);
			e.printStackTrace();
		}
		return response;
	}
	
	@PostMapping("/findRoomByCapacity")
	public Response findRoomByCapacity(@RequestHeader String capacity) {
		Response response = new Response();
		try {
			response.setResultSet(addRoomsService.findByCapacity(capacity));
			response.setOperationStatus(StatusCodes.OPERATIONSUCCESSFULL);

		} catch (WrongDetails e) {
			response.setOperationStatus(StatusCodes.WRONGLOGINCREDENTIALS);
		} catch (Exception e) {
			response.setOperationStatus(StatusCodes.UNKNOWNERROR);
			e.printStackTrace();
		}
		return response;
	}
	
	@PostMapping("/deleteRoomById")
	public Object deleteRoom(@RequestHeader String id) {
		Response response = new Response();
		try {
			response.setResultSet(addRoomsService.deleteRoom(id));
			response.setOperationStatus(StatusCodes.OPERATIONSUCCESSFULL);

		}catch (Exception e) {
			response.setOperationStatus(StatusCodes.UNKNOWNERROR);
			e.printStackTrace();
		}
		return response;
	}
	
	@PostMapping("/getRoomsByAvaibility")
	public Object getRoomsByAvaibility(@RequestHeader String availability) {
		Response response = new Response();
		try {
			response.setResultSet(addRoomsService.getAvailableRooms(availability));
			response.setOperationStatus(StatusCodes.OPERATIONSUCCESSFULL);

		}catch (Exception e) {
			response.setOperationStatus(StatusCodes.UNKNOWNERROR);
			e.printStackTrace();
		}
		return response;
	}

}
