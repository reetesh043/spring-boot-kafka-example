package com.example.kafka.controller;

import com.example.kafka.model.Transaction;
import com.example.kafka.service.TransactionProducerService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/transactions")
@RequiredArgsConstructor
public class TransactionController {

    private final TransactionProducerService producerService;

    @PostMapping("/publish")
    public ResponseEntity<String> publishTransaction(@RequestBody Transaction transaction) {
        try {
            // Send the transaction to the Kafka topic
            producerService.sendTransaction(transaction);
            return ResponseEntity.ok("Transaction published to Kafka");
        } catch (Exception e) {
            return ResponseEntity.status(500).body("Error publishing transaction to Kafka: " + e.getMessage());
        }
    }
}
