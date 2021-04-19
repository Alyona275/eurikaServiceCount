package com.example.microservice_bye.controller;

import com.example.microservice_bye.producer.ProducerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.annotation.EnableKafka;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@EnableKafka
@RestController
public class ByeController {

    private String countHello;

    @Autowired
    private ProducerService producerService;

    @KafkaListener(topics="hello")
    public void msgListener(String hello){
        countHello = hello;
        System.out.println("hello == "+countHello);
    }

    @GetMapping("/bye")
    public String showEnd() {
        producerService.producer();
        System.out.println("Всего доброго! Вы здоровались " + countHello + " раз");
        return "Всего доброго! Вы здоровались " + countHello + " раз";
    }

}
