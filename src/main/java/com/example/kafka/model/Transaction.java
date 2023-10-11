package com.example.kafka.model;

import lombok.*;

@AllArgsConstructor
@NoArgsConstructor
@Builder
@Data
@EqualsAndHashCode
@ToString
public class Transaction {
    private String transactionId;
    private String sender;
    private String receiver;
    private double amount;
    private String description;
    private long timestamp;
}