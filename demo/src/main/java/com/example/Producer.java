package com.example;

import java.util.Properties;
import org.apache.kafka.clients.producer.KafkaProducer;
import org.apache.kafka.clients.producer.ProducerConfig;
import org.apache.kafka.clients.producer.ProducerRecord;
import org.apache.kafka.common.serialization.StringSerializer;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class Producer {
  private  static final Logger log = LoggerFactory.getLogger(Producer.class.getSimpleName());

  public static void main(String[] args) {
    log.info("I am a Kafka Producer");
    // create Producer Properties
    Properties properties = new Properties();
    properties.setProperty(ProducerConfig.BOOTSTRAP_SERVERS_CONFIG, "127.0.0.1:9092");
    properties.setProperty(ProducerConfig.KEY_SERIALIZER_CLASS_CONFIG, StringSerializer.class.getName());
    properties.setProperty(ProducerConfig.VALUE_SERIALIZER_CLASS_CONFIG, StringSerializer.class.getName());

    // create the Producer
    KafkaProducer<String, String> producer = new KafkaProducer<>(properties);

    // create a producer record
    ProducerRecord<String, String> producerRecord =
        new ProducerRecord<>("demo_java", "hello world");

    // send data - asynchronous
    producer.send(producerRecord);

    // flush data - synchronous
    producer.flush();

    // flush and close the Producer
    producer.close();
  }
}