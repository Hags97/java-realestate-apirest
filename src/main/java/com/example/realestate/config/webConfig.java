package com.example.realestate.config;

import org.springframework.http.HttpHeaders;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;

import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration

public class webConfig 
{
    @Bean

    public WebMvcConfigurer corsConfigurer() 
    {
       return new WebMvcConfigurer() 
       {
           @Override
           public void addCorsMappings(CorsRegistry registry) 
           {
               registry.addMapping("/**")
               .allowedOrigins("*****")
               .allowedMethods(HttpMethod.GET.name(), HttpMethod.POST.name(), HttpMethod.DELETE.name())
               .allowedHeaders(HttpHeaders.CONTENT_TYPE, HttpHeaders.AUTHORIZATION);
           }
       };
    }
}
