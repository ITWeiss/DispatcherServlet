package com.example.dispatcherServlet.service;

import com.example.dispatcherServlet.entity.Customer;
import com.example.dispatcherServlet.repository.CustomerRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class CustomerServiceImpl implements CustomerService {

    private final CustomerRepository customerRepository;

    @Override
    public List<Customer> calculateCustomerDiscount() {
        List<Customer> customers = customerRepository.getAllCustomers();
        customers.forEach(customer -> {
            if (customer.getName().length() > 4) {
                customer.setDiscount(10.0);
            }
        });
        return customers;
    }

    @Override
    public void addCustomer(Customer customer) {
        customerRepository.addCustomer(customer);
    }

}
