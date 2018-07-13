package com.jade.config;

import org.springframework.boot.web.servlet.MultipartConfigFactory;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;

import javax.servlet.MultipartConfigElement;


@Configuration
public class WebAppConfig extends WebMvcConfigurerAdapter {


    @Bean
    public MultipartConfigElement multipartConfigElement() {

        MultipartConfigFactory multipartConfigFactory = new MultipartConfigFactory();
        multipartConfigFactory.setMaxFileSize("2MB");
        multipartConfigFactory.setMaxRequestSize("10MB");

        return multipartConfigFactory.createMultipartConfig();
    }
}
