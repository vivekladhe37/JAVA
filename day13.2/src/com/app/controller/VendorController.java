package com.app.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/vendor")
public class VendorController {
	public VendorController() {
		System.out.println("in vendor controller constr");
	}
	@GetMapping("/details")
	public String forwardToDetailsPage()
	{
		System.out.println("in forward to dtls");
		return "/vendor/details";
	}
	
	

}
