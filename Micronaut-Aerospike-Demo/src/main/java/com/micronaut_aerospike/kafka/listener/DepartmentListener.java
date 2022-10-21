package com.micronaut_aerospike.kafka.listener;

import com.micronaut_aerospike.constant.kafkaConstant;
import io.micronaut.configuration.kafka.annotation.KafkaListener;
import io.micronaut.configuration.kafka.annotation.OffsetReset;
import io.micronaut.configuration.kafka.annotation.Topic;

@KafkaListener(offsetReset = OffsetReset.EARLIEST)
public class DepartmentListener {

    @Topic(kafkaConstant.DEPARTMENT_TOPIC_VALUE)
    public void consumeDepartmentNotification(String message) {
        System.out.println(message);
    }
}
