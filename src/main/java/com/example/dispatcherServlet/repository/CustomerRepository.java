package com.example.dispatcherServlet.repository;

import com.example.dispatcherServlet.entity.Customer;

import java.util.List;

public interface CustomerRepository {

    List<Customer> getAllCustomers();

    void addCustomer(Customer customer);
}
