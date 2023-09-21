package com.example.resilience.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.client.RestTemplate;

import io.github.resilience4j.circuitbreaker.annotation.CircuitBreaker;



@Controller
public class BreakerService {
	
	@Autowired
	RestTemplate restTemplate;
	
	
	@CircuitBreaker(name="sevice_A",fallbackMethod = "serviceAFallback")
	@GetMapping("/servicea")
	public String serviceOne(){
		final String url= "http://localhost:8088/billms/allbills";
		String abc=null;
		try {
		 abc=restTemplate.getForObject(url,String.class);
		 System.out.println(abc);
		}catch (Exception e) {
			// TODO: handle exception
		}
		
		return abc;
		
		//return "No calls happend to: "+url;
	}
	public String serviceAFallback(Exception e) {
		return "This is a Service A Fall back" ;
	}
	@RequestMapping("/hello")
	public String serviceTwo(){
		 String url= "hi abc";
		
		
		return url;
	}
}
