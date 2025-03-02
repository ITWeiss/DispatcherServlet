package com.example.dispatcherServlet.controller.view;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping
public class AppController {

    @GetMapping("/hello")
    public String showHomePage() {
        return "index";
    }
}
