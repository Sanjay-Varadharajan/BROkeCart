package com.example.E_Commerce.model;


import com.fasterxml.jackson.annotation.JsonBackReference;
import jakarta.persistence.*;
import lombok.Data;

@Entity
@Data
public class Rating {


    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int rating_id;

    private int stars;

    private String comment;


    @ManyToOne
    @JoinColumn(name = "cus_id")
    private Customer customer;


    @ManyToOne
    @JoinColumn(name="seller_id")
    @JsonBackReference
    private Seller seller;
}
