package com.example;

import java.util.Properties;

import org.apache.kafka.clients.producer.KafkaProducer;
import org.apache.kafka.clients.producer.Producer;
import org.apache.kafka.clients.producer.ProducerRecord;

public class ProducerAsync {
    public static void main(String[] args) {
        Properties props = new Properties();
        props.put("bootstrap.servers",
                "peter-kafka01.foo.bar:9092, peter-kafka02.foo.bar:9092, peter-kafka03.foo.bar:9092");
        props.put("key.serializer", "org.apache.kafka.common.serialization.StringSerializer");
        props.put("value.serializer", "org.apache.kafka.common.serialization.StringSerializer");
        Producer<String, String> producer = new KafkaProducer<>(props);

        try {
            for (int i = 0; i < 3; i++) {
                ProducerRecord<String, String> record = new ProducerRecord<>("peter-basic01",
                        "Apache Kafka is a distributed streaming platform - " + i);
                producer.send(record, new PeterProducerCallback(record));
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            producer.close();
        }
    }
}
