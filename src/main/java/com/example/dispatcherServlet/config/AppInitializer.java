package com.example.dispatcherServlet.config;

import jakarta.servlet.ServletContext;
import jakarta.servlet.ServletException;
import jakarta.servlet.ServletRegistration;
import org.springframework.web.WebApplicationInitializer;
import org.springframework.web.context.support.AnnotationConfigWebApplicationContext;
import org.springframework.web.servlet.DispatcherServlet;

public class AppInitializer implements WebApplicationInitializer {

    @Override
    public void onStartup(ServletContext servletContext) throws ServletException {

        // DispatcherServlet для jsp
        AnnotationConfigWebApplicationContext viewContext = new AnnotationConfigWebApplicationContext();
        viewContext.register(ViewConfig.class);

        ServletRegistration.Dynamic dispatcher = servletContext.addServlet("viewDispatcher", new DispatcherServlet(viewContext));
        dispatcher.setLoadOnStartup(1);
        dispatcher.addMapping("/view/*");

        AnnotationConfigWebApplicationContext apiContext = new AnnotationConfigWebApplicationContext();
        apiContext.register(ApiConfig.class);

        // DispatcherServlet для rest api
        ServletRegistration.Dynamic apiDispatcher = servletContext.addServlet("apiDispatcher", new DispatcherServlet(apiContext));
        apiDispatcher.setLoadOnStartup(1);
        apiDispatcher.addMapping("/api/*");
    }
}
