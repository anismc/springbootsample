package com.example.graphql.model;

import java.util.Date;

import lombok.Data;
@Data
public class BillInput {
	private Double amount;
    private Date billDate;
    private Long restaurantId;
	/*
	 * public Double getAmount() { return amount; } public void setAmount(Double
	 * amount) { this.amount = amount; } public Date getBillDate() { return
	 * billDate; } public void setBillDate(Date billDate) { this.billDate =
	 * billDate; } public Long getRestaurantId() { return restaurantId; } public
	 * void setRestaurantId(Long restaurantId) { this.restaurantId = restaurantId; }
	 */
    
    
}
