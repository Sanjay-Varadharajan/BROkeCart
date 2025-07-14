package com.example.E_Commerce.model;


import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.Data;

@Entity
@Data
public class Product {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int product_id;



    private String product_name;
    private double product_price;
    private String product_info;
    private boolean available;


    public Product(int product_id, String product_name, double product_price, String product_info, boolean available) {
        this.product_id = product_id;
        this.product_name = product_name;
        this.product_price = product_price;
        this.product_info = product_info;
        this.available = available;
    }

    public Product() {
    }

    public Product( String product_name, double product_price, String product_info, boolean available) {
        this.product_name = product_name;
        this.product_price = product_price;
        this.product_info = product_info;
        this.available = available;
    }

}
