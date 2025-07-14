package com.example.E_Commerce.controller;


import com.example.E_Commerce.model.*;
import com.example.E_Commerce.model.Orders;
import com.example.E_Commerce.service.BROke_cart_Service;
import org.aspectj.weaver.ast.Or;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/BROke_cart")
public class BROke_cart_Controller {


    @Autowired
    BROke_cart_Service brokeCartService;


    @GetMapping("/customers")
    public List<Customer> getallcustomer(){
        return brokeCartService.getallcustomer();
    }

    @PostMapping("/addcustomer")
    public String addcustomer(@RequestBody Customer customer){  // i use requestbody instead of requestparam because here i can just pass the object instead of passing every variable in the class
        brokeCartService.addcustomer(customer);
        return customer.getCus_name()+" added Sucessfully";
    }


    @PutMapping("/updatecustomer")
    public String updatecustomer(@RequestBody Customer customer){
        return brokeCartService.updatecustomer(customer);
    }


    @DeleteMapping("/deletecustomer")
    public String deletecustomer(@RequestBody Customer customer){
       return brokeCartService.deletecustomer(customer);
    }

    @GetMapping("/customer/{cus_id}")
    public Customer getcusbyid(@PathVariable("cus_id")int cus_id){
        return brokeCartService.getcusbyid(cus_id);
    }


    @GetMapping("/products")
    public List<Product> showallproduct(){
      return brokeCartService.showallproduct();
   }


   @PostMapping("/addproduct")
    public String addproduct(@RequestBody Product addproduct){
        return brokeCartService.addproduct(addproduct);
   }

   @PutMapping("/updateproduct")
    public String updateproduct(@RequestBody Product product){
        return brokeCartService.updateproduct(product);
   }



   @DeleteMapping("/deleteproduct")
    public String deleteproduct(@RequestBody Product products){
        return brokeCartService.deleteproduct(products);
   }

   @GetMapping("/product/{product_id}")
    public Product getproduct(@PathVariable("product_id")int product_id){
        return brokeCartService.getproduct(product_id);
   }

   @GetMapping("/sellers")
    public List<Seller> getallseller(){
        return brokeCartService.getallseller();
   }

   @PostMapping("/addseller")
    public String addseller(@RequestBody Seller seller){
       return brokeCartService.addseller(seller);
   }

   @PutMapping("/updateseller")
    public String updateseller(@RequestBody Seller seller){
        return brokeCartService.updateseller(seller);
   }

   @DeleteMapping("/deleteseller")
    public String deleteseller(@RequestParam("seller_id")int seller_id){
        return brokeCartService.deleteseller(seller_id);
   }


   @GetMapping("/getorders")
    public List<Orders> showorder(){
        return brokeCartService.showorder();
    }

    @PostMapping("/placeorder/{cus_id}")
    public String placeorder(@PathVariable int cus_id,@RequestBody Orders order){
        return brokeCartService.placeorder(cus_id,order);
    }

    @DeleteMapping("/removeorder")
    public String removeorder(@RequestBody int order_id){
        return brokeCartService.removeorder(order_id);
    }


    @GetMapping("/reviews")
    public List<Rating> ratings(){
        return brokeCartService.ratings();
    }

    @PostMapping("/addreview/{cus_id}/{seller_id}")
    public String addreview(@PathVariable int cus_id,@PathVariable int seller_id,  @RequestParam int stars,
                            @RequestParam String comment){

       return brokeCartService.addreview(cus_id,seller_id,stars,comment);
    }

    @DeleteMapping("/deletereview/{cus_id}/{seller_id}")
    public String deletereview(@PathVariable int cus_id,@PathVariable int seller_id){
        return brokeCartService.deletereview(cus_id,seller_id);
    }








}
