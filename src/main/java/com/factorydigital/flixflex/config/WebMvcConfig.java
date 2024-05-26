package com.factorydigital.flixflex.config;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;
@Configuration
public class WebMvcConfig implements WebMvcConfigurer {

    @Value("${ALLOWED_DOMAIN}")
    private String allowedDomain;

    @Override
    public void addCorsMappings(CorsRegistry registry) {
        registry.addMapping("/**")
                .allowedOrigins("https://flixflex-backend-app-production.up.railway.app",
                        "http://flixflex-backend-app-production.up.railway.app",
                        "https://flixflex-backend-app.railway.internal",
                        "http://flixflex-backend-app.railway.internal")
                .allowedMethods("GET", "POST", "DELETE", "HEAD", "OPTIONS")
                .allowedHeaders("*")
                .allowCredentials(true);
    }
}
