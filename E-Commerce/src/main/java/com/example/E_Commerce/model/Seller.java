package com.example.E_Commerce.model;


import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import jakarta.persistence.*;
import lombok.Data;

import java.util.ArrayList;
import java.util.List;

@Data
@Entity
public class Seller {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int seller_id;


    private String seller_name;
    private String seller_address;
    private String seller_telephone;
    private String mailid;

    @OneToMany(mappedBy = "seller" , cascade = CascadeType.ALL)
    @JsonManagedReference
    private List<Rating> rating=new ArrayList<>();

    public Seller(){

    }


    public Seller(int seller_id, String seller_name, String seller_address, String seller_telephone, String mailid) {
        this.seller_id = seller_id;
        this.seller_name = seller_name;
        this.seller_address = seller_address;
        this.seller_telephone = seller_telephone;
        this.mailid = mailid;
    }


    public Seller(String seller_name, String seller_address, String seller_telephone, String mailid) {
        this.seller_name = seller_name;
        this.seller_address = seller_address;
        this.seller_telephone = seller_telephone;
        this.mailid = mailid;
    }
}
