package com.example.demo.client;


import java.util.HashSet;
import java.util.List;
import java.util.Set;

import org.springframework.stereotype.Component;
import org.springframework.web.reactive.function.client.WebClient;
import reactor.core.publisher.Mono;

import com.example.demo.model.Product;
import com.example.demo.model.ProductPrice;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;

@Component
public class DemoWebClient {
	    private final WebClient webClient;
	    private final ObjectMapper objectMapper;

	    // URLs for both JSON files
	    private static final String URL_PRODUCTS_PRICE_V2 = "https://s3.eu-west-1.amazonaws.com/hackajob-assets1.p.hackajob/challenges/sainsbury_products/products_price_v2.json";
	    private static final String URL_PRODUCTS_V2 = "https://s3.eu-west-1.amazonaws.com/hackajob-assets1.p.hackajob/challenges/sainsbury_products/products_v2.json";

	    public DemoWebClient(WebClient.Builder webClientBuilder, ObjectMapper objectMapper) {
	        this.webClient = webClientBuilder.baseUrl("").build();  // No base URL, use full URL
	        this.objectMapper = objectMapper;
	    }
	    
	    // Fetch and return Set<Product> (Blocking)
	    public Set<Product> fetchProductsV2() {
	        return fetchAndTransformProductData(URL_PRODUCTS_V2);
	    }

	    // Fetch and return Set<ProductPrice> (Blocking)
	    public Set<ProductPrice> fetchProductsPriceV2() {
	        return fetchAndTransformProductPriceData(URL_PRODUCTS_PRICE_V2);
	    }

	    // Method to fetch and transform JSON for products_price_v2.json
	    public Mono<List<Product>> fetchProductsPriceV2(String mono) {
	        return fetchAndTransformProductData(URL_PRODUCTS_PRICE_V2,mono);
	    }

	    // Method to fetch and transform JSON for products_v2.json
	    public Mono<List<ProductPrice>> fetchProductsV2(String mono) {
	        return fetchAndTransformProductPriceData(URL_PRODUCTS_V2,mono);
	    }
	    
	    private Set<Product> fetchAndTransformProductData(String url) {
	        String json = webClient.get()
	                .uri(url)
	                .retrieve()
	                .bodyToMono(String.class)
	                .block();  // Blocking call to get the response synchronously
	        	System.out.println(json);
	        try {
	            Set<Product> productList = objectMapper.readValue(json, new TypeReference<Set<Product>>() {});
	            return new HashSet<>(productList); // Convert List to Set
	        } catch (Exception e) {
	            throw new RuntimeException("Error parsing JSON from URL: " + url, e);
	        }
	    }

	    // Generic method to fetch and transform JSON into Set<ProductPrice>
	    private Set<ProductPrice> fetchAndTransformProductPriceData(String url) {
	        String json = webClient.get()
	                .uri(url)
	                .retrieve()
	                .bodyToMono(String.class)
	                .block();  // Blocking call to get the response synchronously

	        try {
	            Set<ProductPrice> productPriceList = objectMapper.readValue(json, new TypeReference<Set<ProductPrice>>() {});
	            return new HashSet<>(productPriceList); // Convert List to Set
	        } catch (Exception e) {
	            throw new RuntimeException("Error parsing JSON from URL: " + url, e);
	        }
	    }

	    // Generic method to fetch and transform JSON from a URL
	    private Mono<List<Product>> fetchAndTransformProductData(String url, String mono) {
	        return webClient.get()
	                .uri(url)
	                .retrieve()
	                .bodyToMono(String.class)  // Get the JSON response as String
	                .map(json -> {
	                    try {
	                        // Deserialize the JSON into a list of Product objects
	                        return objectMapper.readValue(json, new TypeReference<List<Product>>() {});
	                    } catch (Exception e) {
	                        throw new RuntimeException("Error parsing JSON from URL: " + url, e);
	                    }
	                });
	    }
	    private Mono<List<ProductPrice>> fetchAndTransformProductPriceData(String url,String mono) {
	        return webClient.get()
	                .uri(url)
	                .retrieve()
	                .bodyToMono(String.class)  // Get the JSON response as String
	                .map(json -> {
	                    try {
	                        // Deserialize the JSON into a list of Product objects
	                        return objectMapper.readValue(json, new TypeReference<List<ProductPrice>>() {});
	                    } catch (Exception e) {
	                        throw new RuntimeException("Error parsing JSON from URL: " + url, e);
	                    }
	                });
	    }
}
