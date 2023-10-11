package com.example.kafka.service;

import com.example.kafka.model.Transaction;
import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.RequiredArgsConstructor;
import lombok.SneakyThrows;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
@Slf4j
public class TransactionProducerService {

    @Value(value = "${spring.kafka.topic-name}")
    private String topicName;

    private final KafkaTemplate<String, String> kafkaTemplate;

    @SneakyThrows
    public void sendTransaction(final Transaction message) {
        kafkaTemplate.send(topicName, new ObjectMapper().writeValueAsString(message));
        log.info("Transaction published to Kafka");
    }
}
