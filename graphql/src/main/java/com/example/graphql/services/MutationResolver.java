package com.example.graphql.services;

import graphql.kickstart.tools.GraphQLMutationResolver;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.example.graphql.model.Bill;
import com.example.graphql.model.BillInput;
import com.example.graphql.model.Restaurant;
import com.example.graphql.model.RestaurantInput;
import com.example.graphql.repo.BillRepository;
import com.example.graphql.repo.RestaurantRepository;

@Component
public class MutationResolver implements GraphQLMutationResolver {

    @Autowired
    private RestaurantRepository restaurantRepository;
    @Autowired
    private BillRepository billRepository;

    public Restaurant createRestaurant(RestaurantInput input) {
        Restaurant restaurant = new Restaurant();
        restaurant.setName(input.name());
        restaurant.setCuisineType(input.cuisineType());
        return restaurantRepository.save(restaurant);
    }

    public Bill createBill(BillInput input) {
        Restaurant restaurant = restaurantRepository.findById(input.getRestaurantId())
                .orElseThrow(() -> new IllegalArgumentException("Restaurant not found"));

        Bill bill = new Bill();
        bill.setAmount(input.getAmount());
        bill.setRestaurant(restaurant);
        return billRepository.save(bill);
    }
}
