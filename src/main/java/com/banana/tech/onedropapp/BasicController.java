package com.banana.tech.onedropapp;

import org.apache.tomcat.util.json.JSONParser;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.banana.tech.onedropapp.model.OtpInputVO;
import com.banana.tech.onedropapp.model.OtpResponseVo;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;

@RestController
public class BasicController 
{
	@Autowired
	OtpResponseVo otpResp;

	@GetMapping(path="/")
	public String getOTP() 
	{
		System.out.println("Hello");
		return "SUCCESS";
	}
	@PostMapping(path="/getsms")
	public OtpResponseVo getsms(@RequestBody String inputData) 
	{
		System.out.println("getsms api controller with : "+inputData);
		otpResp.setStatus(true);
		otpResp.setMessage("SUCCESS");
		return otpResp;
	}
	@PostMapping(path="/submitlogin")
	public OtpResponseVo otpValidation(@RequestBody String inputData) throws Exception 
	{
		System.out.println("getsms api controller with : "+inputData);
		ObjectMapper objMapper = new ObjectMapper();
		OtpInputVO otpInput = objMapper.readValue(inputData, OtpInputVO.class);
		String otpNumner = otpInput.getOtpNumber();
		System.out.println("otpNumber : "+otpNumner);
		if(otpNumner.equals("123456")) 
		{
			otpResp.setStatus(true);
			otpResp.setMessage("SUCCESS");
			return otpResp;
		}
		else 
		{
			otpResp.setStatus(false);
			otpResp.setMessage("FAILED");
			return otpResp;
		}
	}
}
