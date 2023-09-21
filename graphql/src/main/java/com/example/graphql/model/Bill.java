package com.example.graphql.model;

import java.util.Date;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;
import lombok.Data;
@Data
@Entity
public class Bill {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private Double amount;
    private Date billDate;
    @ManyToOne
    private Restaurant restaurant;
	/*
	 * public Long getId() { return id; } public void setId(Long id) { this.id = id;
	 * } public Double getAmount() { return amount; } public void setAmount(Double
	 * amount) { this.amount = amount; } public Date getBillDate() { return
	 * billDate; } public void setBillDate(Date billDate) { this.billDate =
	 * billDate; } public Restaurant getRestaurant() { return restaurant; } public
	 * void setRestaurant(Restaurant restaurant) { this.restaurant = restaurant; }
	 */

    // Getters and setters
}