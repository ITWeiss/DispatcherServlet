package com.example.dispatcherServlet.service;

import com.example.dispatcherServlet.entity.Customer;

import java.util.List;

public interface CustomerService {

    List<Customer> calculateCustomerDiscount();

    void addCustomer(Customer customer);
}
