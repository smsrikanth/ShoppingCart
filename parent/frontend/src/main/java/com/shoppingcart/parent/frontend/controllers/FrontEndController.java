package com.shoppingcart.parent.frontend.controllers;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class FrontEndController {

	@GetMapping
	public String home() {
		return "Front end Home";
	}
}
