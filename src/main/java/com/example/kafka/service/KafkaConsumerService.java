package com.example.kafka.service;

import lombok.extern.slf4j.Slf4j;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;

@Service
@Slf4j
public class KafkaConsumerService {

    @KafkaListener(
            id = "demo-kafka-group",
            topics = "test"
    )
    public void consume(final String transaction) {
        log.info("Received transaction: {} ", transaction);
    }
}
