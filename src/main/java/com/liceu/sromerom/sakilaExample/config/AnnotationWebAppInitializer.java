package com.liceu.sromerom.sakilaExample.config;

import org.springframework.web.WebApplicationInitializer;
import org.springframework.web.context.support.AnnotationConfigWebApplicationContext;
import org.springframework.web.servlet.DispatcherServlet;

import javax.servlet.ServletRegistration;

public class AnnotationWebAppInitializer implements WebApplicationInitializer {
    @Override
    public void onStartup(javax.servlet.ServletContext servletContext) {
        AnnotationConfigWebApplicationContext context = new AnnotationConfigWebApplicationContext();
        context.register(AppConfig.class);
        context.setServletContext(servletContext);

        ServletRegistration.Dynamic servlet =
                servletContext.addServlet("dispatcher", new DispatcherServlet(context));
        servlet.setLoadOnStartup(1);
        servlet.addMapping("/");
    }
}
