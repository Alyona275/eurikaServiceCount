package com.example.microservice_hello.controller;

import com.example.microservice_hello.producer.ProducerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HelloController {

    @Autowired
    private ProducerService producerService;

    @GetMapping("/hello")
    public String showHello() {
        producerService.producer();
        System.out.println("Добрый день");
        return "Добрый день";
    }
}
