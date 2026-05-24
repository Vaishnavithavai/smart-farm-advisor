package com.example.KrishiMitra.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/test")
public class TestController {
	
	@GetMapping
	public String test() {
		return "Welcome to KrishiMitra";
	}
	
	   @GetMapping("/farm/test")
	    public String test1() {

	        return "JWT Working Successfully";
	    }
	

}
