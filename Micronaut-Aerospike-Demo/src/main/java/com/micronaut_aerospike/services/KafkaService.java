//package com.micronaut_aerospike.services;
//import java.util.Properties;
//
//import com.micronaut_aerospike.entities.Employee;
//import jakarta.inject.Singleton;
//import org.apache.kafka.clients.producer.KafkaProducer;
//import org.apache.kafka.clients.producer.ProducerConfig;
//import org.apache.kafka.clients.producer.ProducerRecord;
//import org.apache.kafka.common.serialization.IntegerSerializer;
//import org.apache.kafka.common.serialization.StringSerializer;
//@Singleton
//public class KafkaService {
//
//    public void insert(Employee employee)
//    {
//        Object BOOTSTRAP_SERVERS = "localhost:9092";
//        String TOPIC = "Emp";
//
//        Properties producerProperties = new Properties();
//        producerProperties.put(ProducerConfig.BOOTSTRAP_SERVERS_CONFIG, BOOTSTRAP_SERVERS);
//        producerProperties.put(ProducerConfig.KEY_SERIALIZER_CLASS_CONFIG, IntegerSerializer.class);
//        producerProperties.put(ProducerConfig.VALUE_SERIALIZER_CLASS_CONFIG, StringSerializer.class);
//
//
//        KafkaProducer<Integer, String> kafkaProducer = new KafkaProducer(producerProperties);
//
//        ProducerRecord<Integer, String> record = new ProducerRecord<>(TOPIC,"Message-"+"Data Inserted"+" "+employee);
//        kafkaProducer.send(record);
//
//        kafkaProducer.close();
//    }
//
//    public void update(Employee employee)
//    {
//        Object BOOTSTRAP_SERVERS = "localhost:9092";
//        String TOPIC = "Emp";
//
//        Properties producerProperties = new Properties();
//        producerProperties.put(ProducerConfig.BOOTSTRAP_SERVERS_CONFIG, BOOTSTRAP_SERVERS);
//        producerProperties.put(ProducerConfig.KEY_SERIALIZER_CLASS_CONFIG, IntegerSerializer.class);
//        producerProperties.put(ProducerConfig.VALUE_SERIALIZER_CLASS_CONFIG, StringSerializer.class);
//
//
//        KafkaProducer<Integer, String> kafkaProducer = new KafkaProducer(producerProperties);
//
//        ProducerRecord<Integer, String> record = new ProducerRecord<>(TOPIC,"Message-"+"Data Updated"+" "+employee);
//        kafkaProducer.send(record);
//
//        kafkaProducer.close();
//    }
//
//    public void delete(Integer id)
//    {
//        Object BOOTSTRAP_SERVERS = "localhost:9092";
//        String TOPIC = "Emp";
//
//        Properties producerProperties = new Properties();
//        producerProperties.put(ProducerConfig.BOOTSTRAP_SERVERS_CONFIG, BOOTSTRAP_SERVERS);
//        producerProperties.put(ProducerConfig.KEY_SERIALIZER_CLASS_CONFIG, IntegerSerializer.class);
//        producerProperties.put(ProducerConfig.VALUE_SERIALIZER_CLASS_CONFIG, StringSerializer.class);
//
//
//        KafkaProducer<Integer, String> kafkaProducer = new KafkaProducer(producerProperties);
//
//        ProducerRecord<Integer, String> record = new ProducerRecord<>(TOPIC,"Message-"+"Data Deleted"+" "+id);
//        kafkaProducer.send(record);
//
//        kafkaProducer.close();
//    }
//
//
//
//}