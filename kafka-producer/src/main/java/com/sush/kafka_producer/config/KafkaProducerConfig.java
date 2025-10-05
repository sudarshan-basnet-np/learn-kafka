package com.sush.kafka_producer.config;


import org.apache.kafka.clients.admin.NewTopic;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.annotation.Order;

@Configuration
public class KafkaProducerConfig {

    @Bean
    @Order(1)
    public NewTopic newTopic() {
        return new NewTopic("new_topic_1", 3, (short) 1);
    }


    @Bean
    @Order(2)
    public NewTopic topicWithObject() {
        return new NewTopic("topic_with_object", 3, (short) 1);
    }
}
