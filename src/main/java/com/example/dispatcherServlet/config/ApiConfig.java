package com.example.dispatcherServlet.config;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;
import org.springframework.transaction.annotation.EnableTransactionManagement;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;

@Configuration
@EnableWebMvc
@EnableTransactionManagement
@Import(DataBaseConfig.class)
@ComponentScan(basePackages = "com.example.dispatcherServlet.controller.api")
public class ApiConfig {

}
