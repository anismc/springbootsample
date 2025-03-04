package com.example.demo.model;

import com.fasterxml.jackson.annotation.JsonProperty;


import com.fasterxml.jackson.annotation.JsonProperty;

public class ProductPrice {
    
    @JsonProperty("product_uid")
    private String productUid;
    
    @JsonProperty("unit_price")
    private double unitPrice;
    
    @JsonProperty("unit_price_measure")
    private String unitPriceMeasure;
    
    @JsonProperty("unit_price_measure_amount")
    private int unitPriceMeasureAmount;

    // Getters and Setters
    public String getProductUid() { return productUid; }
    public void setProductUid(String productUid) { this.productUid = productUid; }

    public double getUnitPrice() { return unitPrice; }
    public void setUnitPrice(double unitPrice) { this.unitPrice = unitPrice; }

    public String getUnitPriceMeasure() { return unitPriceMeasure; }
    public void setUnitPriceMeasure(String unitPriceMeasure) { this.unitPriceMeasure = unitPriceMeasure; }

    public int getUnitPriceMeasureAmount() { return unitPriceMeasureAmount; }
    public void setUnitPriceMeasureAmount(int unitPriceMeasureAmount) { this.unitPriceMeasureAmount = unitPriceMeasureAmount; }
}
