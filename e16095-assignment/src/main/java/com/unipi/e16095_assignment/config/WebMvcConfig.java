package com.unipi.e16095_assignment.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
public class WebMvcConfig implements WebMvcConfigurer {

    @Autowired
    private AuthInterceptor authInterceptor;

    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        registry.addInterceptor(authInterceptor)
                .addPathPatterns("/api/**")                  // Intercept every single request
                .excludePathPatterns(
                        "/api/login",                           // Exclude login GET/POST route
                        "/api/register",                        // Exclude register GET/POST route
                        "/css/**", "/js/**", "/images/**"       // Exclude static assets
                );
    }
}