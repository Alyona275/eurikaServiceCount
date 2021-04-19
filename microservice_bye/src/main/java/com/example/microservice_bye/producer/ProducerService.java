package com.example.microservice_bye.producer;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.kafka.support.SendResult;
import org.springframework.stereotype.Service;
import org.springframework.util.concurrent.ListenableFuture;

import java.util.concurrent.ExecutionException;

@Service
public class ProducerService {

    Integer count = 0;
    @Autowired
    private KafkaTemplate<String, String> kafkaTemplate;

    public void producer() {
        try {
            ListenableFuture<SendResult<String, String>> future =kafkaTemplate.send("byeCount", String.valueOf(count));
            System.out.println("prodBye == "+future.get().getRecordMetadata().toString());
            String[] s = future.get().getRecordMetadata().toString().split("@");
            count = Integer.valueOf(s[1]) + 1;
            System.out.println(count);
            kafkaTemplate.send("bye", "count", String.valueOf(count));
        } catch (InterruptedException e) {
            e.printStackTrace();
        } catch (ExecutionException e) {
            e.printStackTrace();
        }
    }
}
