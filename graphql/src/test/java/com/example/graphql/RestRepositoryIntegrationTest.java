package com.example.graphql;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.Assert.assertThat;

import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.context.junit4.SpringRunner;

import com.example.graphql.model.Restaurant;
import com.example.graphql.repo.RestaurantRepository;

@RunWith(SpringRunner.class)
@DataJpaTest
public class RestRepositoryIntegrationTest {
    
    @Autowired
    private RestaurantRepository restaurantRepository;
   
    @Test
    public void whenCalledSave_thenCorrectNumberOfUsers() {
    	Restaurant restaurant = new Restaurant();
        restaurant.setName("Bob");
        restaurant.setCuisineType("abc");
    	restaurantRepository.save(restaurant);
        List<Restaurant> restaurants = (List<Restaurant>) restaurantRepository.findAll();
        
        assertThat(restaurants.size()).isEqualTo(1);
    }    
}
