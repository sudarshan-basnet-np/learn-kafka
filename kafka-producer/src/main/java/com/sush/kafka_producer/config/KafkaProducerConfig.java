package com.sush.kafka_producer.config;


import org.apache.kafka.clients.admin.NewTopic;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class KafkaProducerConfig {

    @Bean
    NewTopic newTopic() {
        return new NewTopic("new_topic_1", 3, (short) 1);
    }
}
