package com.example.Address.config;

import feign.auth.BasicAuthRequestInterceptor;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;

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
