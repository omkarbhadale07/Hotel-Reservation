package com.ts.hotelreservation.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class HomeController {
	
	@RequestMapping({ "/" })
    public String home() throws Exception {
        return "index";
    }
	
	@GetMapping({ "/customerlogin" })
    public String customerlogin() {
        return "index";
    }
	
	@GetMapping({ "/login" })
    public String login() {
        return "index";
    }
	
	@GetMapping({ "/allcustomers" })
    public String allcustomers() {
        return "index";
    }
	
	@GetMapping({ "/customerdetails" })
    public String customerdetails() {
        return "index";
	}  
	
	@GetMapping({ "/allrooms" })
    public String allrooms() {
        return "index";
	}  
	@GetMapping({ "/addroom" })
    public String addrooms() {
        return "index";
	}  
	@GetMapping({ "/registercustomer" })
    public String registercustomer() {
        return "index";
	} 
	
	@GetMapping({ "/registeredroom" })
    public String registeredroom() {
        return "index";
	} 
	
	@GetMapping({ "/reservedroom" })
    public String reservedroom() {
        return "index";
	} 

}
