package com.example.E_Commerce.service;


import com.example.E_Commerce.model.*;
import com.example.E_Commerce.repository.*;
import com.example.E_Commerce.model.Orders;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class BROke_cart_Service {

    @Autowired
    Customer_Repo customerRepo;

    @Autowired
    Product_Repo productRepo;


    @Autowired
    Seller_Repo sellerRepo;

    @Autowired
    Order_Repo orderRepo;

    @Autowired
    Rating_Repo ratingRepo;


    public List<Customer> getallcustomer() {
        return customerRepo.findAll();
    }


    public void addcustomer(Customer customer) {
        customerRepo.save(customer);
    }

    public String updatecustomer(Customer customer) {
       Optional<Customer> existcustomer=customerRepo.findById(customer.getCus_id());

       if(existcustomer.isEmpty()){
           return "Customer Not Found , Please Recheck and try Again";
       }


       Customer adding=existcustomer.get(); //we getting the existing id from the db so it dont add a non existing customer

        adding.setCus_name(customer.getCus_name());
        adding.setCus_address(customer.getCus_address());
        adding.setCus_mobile(customer.getCus_mobile());
        adding.setCus_mail(customer.getCus_mail());



       customerRepo.save(adding);
       return adding.getCus_name()+" Updated Sucessfully";
    }


    public String deletecustomer(Customer customer) {

        Optional<Customer> exist=customerRepo.findById(customer.getCus_id());

        if(exist.isEmpty()){
            return "Customer Not Found";
        }

        Customer tbr=exist.get();  //this gets  the data from the database, the customer in the argument is just the input given by customer
        customerRepo.delete(tbr);

        return tbr.getCus_name()+"'s Account Removed Sucessfully";
    }

    public Customer getcusbyid(int cusId) {
        Optional<Customer> customer=customerRepo.findById(cusId);

        if(customer.isEmpty()){
            throw new RuntimeException("Customer with this "+cusId+" Not Found");
        }

       return customer.get();

    }

    public List<Product> showallproduct() {
        return productRepo.findAll();
    }


    public String addproduct(Product addproduct) {
        productRepo.save(addproduct);
        return "Product added Successfully";
    }

    public String updateproduct(Product product) {

       Optional<Product> pro=productRepo.findById(product.getProduct_id());

       if(pro.isEmpty()){
           return "Product Not Found";
       }

       Product ap=pro.get();

       ap.setProduct_name(product.getProduct_name());
       ap.setProduct_price(product.getProduct_price());
       ap.setProduct_info(product.getProduct_info());
       ap.setAvailable(product.isAvailable());

       productRepo.save(ap);
       return "Product Updated Successfully";
    }


    public String deleteproduct(Product products) {

        Optional<Product> pro=productRepo.findById(products.getProduct_id());


        if(pro.isEmpty()){
            return "Product Not Found Please check Properly";
        }

        Product id=pro.get();

        productRepo.delete(id);

        return "Deleted Successfully";
    }

    public Product getproduct(int productId) {
        Optional<Product> prod=productRepo.findById(productId);

        if(prod.isEmpty()){
            throw new RuntimeException("Product Not Please check and try Again");
        }

        return prod.get();
    }

    public List<Seller> getallseller() {
        return sellerRepo.findAll();
    }


    public String addseller(Seller seller) {
        sellerRepo.save(seller);
        return "Seller "+seller.getSeller_name()+" Added Sucessfully";
    }

    public String updateseller(Seller seller) {

        Optional<Seller> sel=sellerRepo.findById(seller.getSeller_id());//fetching the seller tables value and checking the id


        Seller seller1=sel.get(); //getting the whole table by get keyword


        seller1.setSeller_name(seller.getSeller_name());
        seller1.setSeller_address(seller.getSeller_address());
        seller1.setSeller_telephone(seller.getSeller_telephone());
        seller1.setMailid(seller.getMailid());


        sellerRepo.save(seller1);

        return "Seller " + seller.getSeller_name()+" Updated Sucessfully";
    }


    public String deleteseller(int sellerId) {
        Optional<Seller> sel=sellerRepo.findById(sellerId);

        if(sel.isEmpty()){
            return "Seller Not Found";
        }

        sellerRepo.deleteById(sellerId);


        return "Seller deleted Sucessfully";
    }

    public List<Orders> showorder() {
        return orderRepo.findAll();
    }

    public String placeorder(int cus_id, Orders order) {

        Optional<Customer> customer=customerRepo.findById(cus_id);

        if(customer.isEmpty()){
            throw new RuntimeException("Customer Not Found");
        }

        Customer cus=customer.get();
        order.setCustomer(cus);
        orderRepo.save(order);

        return "Order Placed Sucessfully!..";

    }

    public String removeorder(int order_id) {

        Optional<Orders> order=orderRepo.findById(order_id);

        if(order.isEmpty()){
            throw new RuntimeException("Order Not Found!....");
        }

        Orders od=order.get();
        orderRepo.delete(od);

        return "Order Removed Sucessfully...";
    }

    public List<Rating> ratings() {
        return ratingRepo.findAll();
    }

    public String addreview(int cusId, int sellerId,int stars,String comment) {

        Optional<Customer> id=customerRepo.findById(cusId);
        Optional<Seller> sid=sellerRepo.findById(sellerId);

        if(id.isEmpty()){
            throw new RuntimeException("Account Not Found!....");
        }

        if(sid.isEmpty()){
            throw new RuntimeException("Seller Not FOund...");
        }

        if(id.isEmpty() && sid.isEmpty()){
            throw new RuntimeException("Customer and Seller Not Found...");
        }

        Customer cus=id.get();
        Seller sel=sid.get();

        Rating rating=new Rating();
        rating.setCustomer(cus);
        rating.setSeller(sel);
        rating.setStars(stars);
        rating.setComment(comment);
        ratingRepo.save(rating);

        return "Rating Added Sucessfully..";
    }


    public String deletereview(int cusId, int sellerId) {

        Optional<Customer> customer=customerRepo.findById(cusId);
        Optional<Seller> seller=sellerRepo.findById(sellerId);

        if(customer.isEmpty()){
            throw new RuntimeException("Customer Not Found");
        }

        if(seller.isEmpty()){
            throw new RuntimeException("Seller Not FOund");
        }
        Rating rating1 = ratingRepo.findByCustomerAndSeller(customer.get(), seller.get());

        if(rating1==null){
            return "No rating found for this customer and seller combo.";
        }
        ratingRepo.delete(rating1);

        return "Review Deleted Sucessfully";
    }
}
