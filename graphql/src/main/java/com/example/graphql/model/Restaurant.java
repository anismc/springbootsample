package com.example.graphql.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
@Data
@Entity
public class Restaurant {
   


	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    private String cuisineType;
	
	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getCuisineType() {
		return cuisineType;
	}

	public void setCuisineType(String cuisineType) {
		this.cuisineType = cuisineType;
	}
	 
    
	public Restaurant(String name, String cuisineType) {
		super();
		this.name = name;
		this.cuisineType = cuisineType;
	}
	 public Restaurant() {
			super();
			// TODO Auto-generated constructor stub
		}

	public Restaurant(Long id, String name, String cuisineType) {
		super();
		this.id = id;
		this.name = name;
		this.cuisineType = cuisineType;
	}
	 


}