package com.micronaut_aerospike.kafka.client;

import com.micronaut_aerospike.constant.kafkaConstant;
import jakarta.inject.Inject;
import jakarta.inject.Singleton;

@Singleton
public class KafkaDepartment {
    @Inject
    KafkaProducer kafkaProducer;

    public void sendDepartmentNotification(String message) {
        kafkaProducer.send(kafkaConstant.DEPARTMENT_TOPIC_VALUE,message);
    }
}
