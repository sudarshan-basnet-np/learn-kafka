package com.sush.kafka_consumer.consumer;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;

@Service
public class KafkaMessageListener {

    Logger log = LoggerFactory.getLogger(KafkaMessageListener.class);

    @KafkaListener(topics = "new_topic_1", groupId = "gt-group")
    public void consume(String message) {
        log.info("consumer0 consume the message {} " , message);
    }


    @KafkaListener(topics = "new_topic_1", groupId = "gt-group")
    public void consume1(String message) {
        log.info("consumer1 consume the message {} " , message);
    }

    @KafkaListener(topics = "new_topic_1", groupId = "gt-group")
    public void consume2(String message) {
        log.info("consumer2 consume the message {} " , message);
    }

    @KafkaListener(topics = "new_topic_1", groupId = "gt-group")
    public void consume3(String message) {
        log.info("consumer3 consume the message {} " , message);
    }
}
