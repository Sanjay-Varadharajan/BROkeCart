package com.example.E_Commerce.repository;

import com.example.E_Commerce.model.Customer;
import com.example.E_Commerce.model.Rating;
import com.example.E_Commerce.model.Seller;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface Rating_Repo extends JpaRepository<Rating, Integer> {

    Rating findByCustomerAndSeller(Customer customer, Seller seller);
}
