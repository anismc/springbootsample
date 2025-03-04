package com.example.demo.model;

import com.fasterxml.jackson.annotation.JsonProperty;

public class Product {
    
    @JsonProperty("product_uid")
    private String productUid;
    @JsonProperty("product_type")
    private String productType;
    private String name;
    @JsonProperty("full_url")
    private String fullUrl;

    // Getters and Setters
    public String getProductUid() { return productUid; }
    public void setProductUid(String productUid) { this.productUid = productUid; }

    public String getProductType() { return productType; }
    public void setProductType(String productType) { this.productType = productType; }

    public String getName() { return name; }
    public void setName(String name) { this.name = name; }

    public String getFullUrl() { return fullUrl; }
    public void setFullUrl(String fullUrl) { this.fullUrl = fullUrl; 
    }
}
