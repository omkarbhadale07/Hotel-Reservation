package com.ts.hotelreservation.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.ts.hotelreservation.exceptions.WrongLoginCredentials;
import com.ts.hotelreservation.model.Admin;
import com.ts.hotelreservation.model.Response;
import com.ts.hotelreservation.service.AdminServices;
import com.ts.hotelreservation.utils.StatusCodes;


@RestController
public class AdminController {
	
	@Autowired
	AdminServices adminServices;
	
	@PostMapping("/loginAdmin")
	public Response loginAdmin(@RequestBody Admin admin) {

		Response response = new Response();
		try {
			response.setResultSet(adminServices.LoginAdmin(admin));
			response.setOperationStatus(StatusCodes.OPERATIONSUCCESSFULL);

		} catch (WrongLoginCredentials e) {
			response.setOperationStatus(StatusCodes.WRONGLOGINCREDENTIALS);
		} catch (Exception e) {
			response.setOperationStatus(StatusCodes.UNKNOWNERROR);
			e.printStackTrace();

		}

		return response;
	}

}
