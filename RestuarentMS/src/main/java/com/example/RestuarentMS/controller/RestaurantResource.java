package com.example.RestuarentMS.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.RestuarentMS.bean.Restaurant;



@RestController
@RequestMapping("/restrms")
public class RestaurantResource {
	
	private List<Restaurant> listAllRestr(){
		
		 // Step 2: Create a list of restaurant objects
        List<Restaurant> restaurants = new ArrayList<>();
        restaurants.add(new Restaurant("Restaurant A","Chinese"));
        restaurants.add(new Restaurant("Restaurant B","Indian"));
        restaurants.add(new Restaurant("Restaurant C","Mexican"));

        // Step 3: Use Java 8 stream to extract the restaurant names
		/*
		 * List<String> restaurantNames = restaurants.stream() .map(restaurant ->
		 * restaurant.getName() +" - "+ restaurant.getType())
		 * .collect(Collectors.toCollection(ArrayList::new));
		 */
		return restaurants;
		
	}
	@RequestMapping("/service")
	public ResponseEntity<List<Restaurant>> getRestuarentdetails() {
	    List<Restaurant> restaurants = listAllRestr();
	    return new ResponseEntity<>(restaurants, HttpStatus.OK);
	}
	@GetMapping("/hello")
	public String hello() {
		 return "hello world";
	 }
}
