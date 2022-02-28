package com.example.Address.config;

import feign.auth.BasicAuthRequestInterceptor;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;

// I did this if authentication is required for API communication. In this project, it won't be, ViaCep, you don't need an account
public class ZipCodeFeignConfig {
    @Value("${api.zipcode.username}")
    private String user;

    @Value("${api.zipcode.password}")
    private String password;

    private BasicAuthRequestInterceptor basicAuthRequestInterceptor;


    @Bean
    public BasicAuthRequestInterceptor basicAuthRequestInterceptor() {
        return new BasicAuthRequestInterceptor(user, password);
    }
}
