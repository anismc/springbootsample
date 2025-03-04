package com.example.demo.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import java.util.Optional;
import java.util.Set;
import java.util.function.Function;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.client.DemoWebClient;
import com.example.demo.model.Product;
import com.example.demo.model.ProductPrice;

@Service
public class DemoService {
	
	@Autowired
	DemoWebClient client;
	
	public record Person(String name, int age) {};
	public record ProductWithPrice(
     String productid,
     String productType,
     String name,
     String fullUrl,
     double unitPrice,
     String unitPriceMeasure,
     int unitPriceMeasureAmount) {};
	public List getNames(){
		List<Person> list = new ArrayList<Person>();
		Person p = new Person("Ethan",4);
		list.add(p);
		list.add(new Person("alan",12));
		
		return list;
	}
	public List getNames(int age,String name) {
		// TODO Auto-generated method stub
		List<Person> list = new ArrayList<Person>();
		Person p = new Person(name,age);
		list.add(p);
		Set<Product> products = client.fetchProductsV2();
		
		for (Product pr : products) {
			System.out.println(pr.getName());
		}
		
		return list;
	}
	public List getValues() {
		
		List<ProductWithPrice> list = new ArrayList<ProductWithPrice>();
		Set<Product> products = client.fetchProductsV2();
		Set<ProductPrice> productprices = client.fetchProductsPriceV2();
		Map<String,ProductPrice> priceMap= productprices.stream().collect(Collectors.toMap(ProductPrice::getProductUid, Function.identity()));
		
		
		
	    list = products.stream()
                .map(p -> Optional.ofNullable(priceMap.get(p.getProductUid()))
                        .map(pp -> new ProductWithPrice(
                                p.getProductUid(), p.getProductType(), p.getName(), p.getFullUrl(),
                                pp.getUnitPrice(), pp.getUnitPriceMeasure(), pp.getUnitPriceMeasureAmount()))
                        .orElse(null)) // Handle missing ProductPrice
                .filter(Objects::nonNull) // Remove null values
                .collect(Collectors.toList());
		
		return list;
	}
	public List getValues(String type) {
		
		List<ProductWithPrice> list = new ArrayList<ProductWithPrice>();
		Set<Product> products = client.fetchProductsV2();
		Set<ProductPrice> productprices = client.fetchProductsPriceV2();
		Map<String,ProductPrice> priceMap= productprices.stream().collect(Collectors.toMap(ProductPrice::getProductUid, Function.identity()));
		
		
		
	    list = products.stream().filter(a-> a.getProductType().equals(type))
                .map(p -> Optional.ofNullable(priceMap.get(p.getProductUid()))
                        .map(pp -> new ProductWithPrice(
                                p.getProductUid(), p.getProductType(), p.getName(), p.getFullUrl(),
                                pp.getUnitPrice(), pp.getUnitPriceMeasure(), pp.getUnitPriceMeasureAmount()))
                        .orElse(null)) // Handle missing ProductPrice
                .filter(Objects::nonNull) // Remove null values
                .collect(Collectors.toList());
		
		return list;
	}
}
