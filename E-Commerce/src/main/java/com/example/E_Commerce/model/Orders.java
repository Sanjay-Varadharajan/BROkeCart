package com.example.E_Commerce.model;


import jakarta.persistence.*;
import lombok.Data;

@Entity

@Data
public class Orders {



    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int order_id;


    @ManyToOne
    @JoinColumn(name="cus_id")
    private Customer customer;
}
