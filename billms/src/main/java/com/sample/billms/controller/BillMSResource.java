package com.sample.billms.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.sample.billms.bean.Bill;
@RestController
public class BillMSResource {
	
	private List getList() {
		List<Bill> bills = new ArrayList<Bill>();
		Bill bill1 = new Bill(1L, "Electricity Bill", 100.0f);
	    bills.add(bill1);
	
	    Bill bill2 = new Bill(2L, "Water Bill", 50.0f);
	    bills.add(bill2);
	
	    Bill bill3 = new Bill(3L, "Internet Bill", 80.0f);
	    bills.add(bill3);
	    return bills;
	}
    
	@RequestMapping("/allbills")
	public List getAllBills() {
		return getList();
		
	}

}
