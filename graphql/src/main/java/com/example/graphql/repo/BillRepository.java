package com.example.graphql.repo;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.graphql.model.Bill;


public interface BillRepository extends JpaRepository<Bill, Long> {
}
