package com.example.demo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.service.DemoService;

@RestController
public class DemoController {
	@Autowired
	DemoService service;
	

	@GetMapping("api/person/{age}")
	ResponseEntity<List> getPersonbyAge(@PathVariable int age,@RequestParam String name){
		return ResponseEntity.status(HttpStatus.OK).body(service.getNames(age,name));
	}
	
	@GetMapping("/api/person")
	ResponseEntity<List> getPerson(@RequestParam(required = false) String type){
		if (type == null) {
	         return ResponseEntity.status(HttpStatus.NOT_ACCEPTABLE).body(service.getValues());
	     } else {
	    	 System.out.println(type);
	         return ResponseEntity.status(HttpStatus.OK).body(service.getValues(type));
	     }
		
	}
	
}
