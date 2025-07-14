package com.example.E_Commerce.model;


import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.boot.autoconfigure.web.WebProperties;

import java.util.ArrayList;
import java.util.List;

@Entity
@Data
public class Customer {

    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    private int cus_id;
    private String cus_name;
    private String cus_address;
    private String cus_mobile;
    private String cus_mail;

    @OneToMany(mappedBy = "customer", cascade = CascadeType.ALL)
    private List<Orders> orders=new ArrayList<>();


    @OneToMany(mappedBy = "customer", cascade = CascadeType.ALL)
    private List<Rating> ratings = new ArrayList<>();


    public Customer(String cus_name, String cus_address, String cus_mobile, String cus_mail) {
        this.cus_name = cus_name;
        this.cus_address = cus_address;
        this.cus_mobile = cus_mobile;
        this.cus_mail = cus_mail;
    }

    public Customer(int cus_id, String cus_name, String cus_address, String cus_mobile, String cus_mail) {
        this.cus_id = cus_id;
        this.cus_name = cus_name;
        this.cus_address = cus_address;
        this.cus_mobile = cus_mobile;
        this.cus_mail = cus_mail;
    }

    public Customer() {

    }
}
