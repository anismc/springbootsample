package com.example.graphql.repo;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.graphql.model.Restaurant;

public interface RestaurantRepository extends JpaRepository<Restaurant, Long> {
}