package com.shoppingcart.parent.backend.controllers;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class BackEndAdminController {
	
	@GetMapping
	public String home() {
		return "Back end Home";
	}
}
