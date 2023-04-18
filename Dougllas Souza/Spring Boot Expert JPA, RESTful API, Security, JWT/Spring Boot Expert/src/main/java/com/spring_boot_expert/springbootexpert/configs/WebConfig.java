package com.spring_boot_expert.springbootexpert.configs;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
public class WebConfig implements WebMvcConfigurer {

    @Value("http://localhost:8080,http://localhost:4200")
    private String corsOriginPaterns = "";

    @Override
    public void addCorsMappings(CorsRegistry registry) {
        String[] allowedOrigins = corsOriginPaterns.split(",");
        registry.addMapping("/**")
                .allowedMethods("*")
                .allowedOrigins(allowedOrigins)
                .allowCredentials(true);
    }
}
