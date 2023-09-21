package com.sample.billms.bean;

public class Bill {
  Long id;
  String billName;
  Float price;
  
  public Bill(Long id, String billName, Float price) {
		super();
		this.id = id;
		this.billName = billName;
		this.price = price;
	}
public Long getId() {
	return id;
}

public void setId(Long id) {
	this.id = id;
}
public String getBillName() {
	return billName;
}
public void setBillName(String billName) {
	this.billName = billName;
}
public Float getPrice() {
	return price;
}
public void setPrice(Float price) {
	this.price = price;
}
	
}
