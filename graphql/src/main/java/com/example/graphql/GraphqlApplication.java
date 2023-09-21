package com.example.graphql;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import com.example.graphql.model.Restaurant;
import com.example.graphql.repo.RestaurantRepository;

@SpringBootApplication
public class GraphqlApplication {

	public static void main(String[] args) {
		SpringApplication.run(GraphqlApplication.class, args);
	}
	
	@Bean
    public CommandLineRunner run(RestaurantRepository RestaurantRepository) throws Exception {
        return (String[] args) -> {
            Restaurant restaurant1 = new Restaurant("John", "john@domain.com");
            Restaurant restaurant2 = new Restaurant("Julie", "julie@domain.com");
            RestaurantRepository.save(restaurant1);
            RestaurantRepository.save(restaurant2);
            RestaurantRepository.findAll().forEach(Restaurant -> System.out.println(Restaurant));
        };
    }

}
