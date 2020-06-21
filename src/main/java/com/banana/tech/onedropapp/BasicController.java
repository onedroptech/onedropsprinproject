package com.banana.tech.onedropapp;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class BasicController 
{

	@GetMapping(path="/")
	public String getOTP() 
	{
		System.out.println("Hello");
		return "SUCCESS";
	}
}
