package com.sush.kafka_producer.controller;

import com.sush.kafka_producer.service.KafkaMessagePublisher;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

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
            return ResponseEntity.ok().body("Successfully publish  message");
        } catch (Exception ex) {
            throw new RuntimeException(ex);
        }
    }
}
