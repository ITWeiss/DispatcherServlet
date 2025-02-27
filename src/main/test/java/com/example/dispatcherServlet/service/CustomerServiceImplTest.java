package com.example.dispatcherServlet.service;

import com.example.dispatcherServlet.entity.Customer;
import com.example.dispatcherServlet.repository.CustomerRepository;
import org.instancio.Instancio;
import org.instancio.Select;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.ArgumentCaptor;
import org.mockito.Captor;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.Arrays;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertEquals;

@ExtendWith(MockitoExtension.class)
public class CustomerServiceImplTest {
    private CustomerServiceImpl customerService;
    @Mock
    private CustomerRepository customerRepository;
    @Captor
    private ArgumentCaptor<Customer> customerCaptor;

    @BeforeEach
    public void setUp() {
        customerService = new CustomerServiceImpl(customerRepository);
    }

    @Test
    void calculateCustomerDiscount() {
        List<Customer> customers = Arrays.asList(
                Instancio.of(Customer.class).set(Select.field(Customer::getName), "James")
                        .set(Select.field(Customer::getDiscount), 10.0).create(),
                Instancio.of(Customer.class).set(Select.field(Customer::getName), "John")
                        .set(Select.field(Customer::getDiscount), 0.0).create());

        Mockito.when(customerRepository.getAllCustomers()).thenReturn(customers);

        List<Customer> result = customerService.calculateCustomerDiscount();

        assertEquals(10.0, result.get(0).getDiscount());
        assertEquals(0.0, result.get(1).getDiscount());
    }

    @Test
    void addCustomer() {
        Customer customer = new Customer();
        customer.setName("John Doe");

        customerService.addCustomer(customer);

        Mockito.verify(customerRepository, Mockito.times(1)).addCustomer(customerCaptor.capture());

        Customer cupturedCustomer = customerCaptor.getValue();

        assertThat(cupturedCustomer.getName()).isEqualTo("John Doe");
    }

}
