package com.example.graphql.services;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.example.graphql.model.Restaurant;
import com.example.graphql.repo.BillRepository;
import com.example.graphql.repo.RestaurantRepository;

import graphql.kickstart.tools.GraphQLQueryResolver;

import java.util.List;
import java.util.Optional;

@Component
public class QueryResolver implements GraphQLQueryResolver {

    @Autowired
    private RestaurantRepository restaurantRepository;
    @Autowired
    private BillRepository billRepository;

    public Restaurant restaurant(Long id) {
        Optional<Restaurant> restaurant = restaurantRepository.findById(id);
        return restaurant.orElse(null);
    }

    public List<Restaurant> restaurants() {
        return restaurantRepository.findAll();
    }
}
