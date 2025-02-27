package com.example.dispatcherServlet.controller.api;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping
public class CustomerController {

    @GetMapping(value = "/customers")
    public List<String> getCustomers() {
        return List.of("Customer1", "Customer2", "Customer3");
    }

}
