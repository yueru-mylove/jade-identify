package com.jade;


import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@EnableAutoConfiguration
public class ApplicationServer {

    public static void main(String[] args) {
        SpringApplication.run(ApplicationServer.class, args);
    }


}
