package com.sush.kafka_producer.service;

import org.apache.kafka.clients.producer.RecordMetadata;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.kafka.support.SendResult;
import org.springframework.stereotype.Component;

import java.util.concurrent.CompletableFuture;

@Component
public class KafkaMessagePublisher {

    private static final Logger log = LoggerFactory.getLogger(KafkaMessagePublisher.class);

    private final KafkaTemplate<String, Object> kafkaTemplate;

    public KafkaMessagePublisher(KafkaTemplate<String, Object> kafkaTemplate) {
        this.kafkaTemplate = kafkaTemplate;
    }


    public void sendMessage(String message) {
        CompletableFuture<SendResult<String, Object>> future = this.kafkaTemplate.send("new_topic_1", message);
        future.whenComplete((result, exception) -> {
            if (exception == null) {
                log.info(" Sent message [ {} ] with offset [ {} ]", message, result.getRecordMetadata().offset());
            } else  {
                log.error("Unable to send message due to[ {} ]", exception.getMessage());
            }
        });
    }
}
