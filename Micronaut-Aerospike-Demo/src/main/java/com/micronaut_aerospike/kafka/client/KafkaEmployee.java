package com.micronaut_aerospike.kafka.client;

import com.micronaut_aerospike.constant.kafkaConstant;
import jakarta.inject.Inject;
import jakarta.inject.Singleton;

@Singleton
public class KafkaEmployee {
    @Inject
    KafkaProducer kafkaProducer;

    public void sendEmployeeNotification(String message) {
        kafkaProducer.send(kafkaConstant.EMPLOYEE_TOPIC_VALUE,message);
    }
}
