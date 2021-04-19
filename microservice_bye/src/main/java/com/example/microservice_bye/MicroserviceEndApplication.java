package com.example.microservice_bye;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

@SpringBootApplication
@EnableDiscoveryClient
public class MicroserviceEndApplication {

    public static void main(String[] args) {
        SpringApplication.run(MicroserviceEndApplication.class, args);
    }

}
