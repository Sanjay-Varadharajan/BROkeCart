package com.example.E_Commerce.repository;


import com.example.E_Commerce.model.Orders;
import org.springframework.data.jpa.repository.JpaRepository;

public interface Order_Repo extends JpaRepository<Orders,Integer> {
}
