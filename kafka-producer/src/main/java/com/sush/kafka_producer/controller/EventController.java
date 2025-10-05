package com.sush.kafka_producer.controller;

import com.sush.kafka_producer.dto.Customer;
import com.sush.kafka_producer.service.KafkaMessagePublisher;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1/producer-app")
public class EventController {

    private final KafkaMessagePublisher kafkaMessagePublisher;

    public EventController(KafkaMessagePublisher kafkaMessagePublisher) {
        this.kafkaMessagePublisher = kafkaMessagePublisher;
    }

    @GetMapping("/publish/{message}")
    public ResponseEntity<String> sendMessage(@PathVariable String message) {
        try {
            for (int i = 0; i < 10_000; i++) {
                kafkaMessagePublisher.sendMessage(message + " : " + i);
            }
            return ResponseEntity.ok().body("Successfully publish message");
        } catch (Exception ex) {
            throw new RuntimeException(ex);
        }
    }


    @PostMapping("/publish/json")
    public ResponseEntity<String> publishJson(@RequestBody Customer customer) {
        try {
            kafkaMessagePublisher.sendMessage(customer);
            return  ResponseEntity.ok().body("Successfully publish message");
        } catch (Exception ex) {
            throw new RuntimeException(ex);
        }
    }
}
