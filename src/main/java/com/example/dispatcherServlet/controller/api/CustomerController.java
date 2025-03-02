package com.example.dispatcherServlet.controller.api;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping
public class CustomerController {

    @GetMapping(value = "/customers")
    public ResponseEntity<List<String>> getCustomers() {
        List<String> customers = List.of("Customer1", "Customer2", "Customer3");
        return ResponseEntity.ok(customers);
    }

}
