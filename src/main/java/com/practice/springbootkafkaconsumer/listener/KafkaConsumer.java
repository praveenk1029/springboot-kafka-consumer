package com.practice.springbootkafkaconsumer.listener;

import com.practice.springbootkafkaconsumer.model.Person;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;

@Service
public class KafkaConsumer {

    @KafkaListener(topics = "KafkaExample", groupId = "group_id")
    public void consume(String message){
        System.out.println("Consumed message from Topic:::" + message);
    }

    @KafkaListener(topics = "KafkaExampleJson", groupId = "group_json",
    containerFactory = "personKafkaListenerFactory")
    public void consumeJson(Person person){
        System.out.println("Consumed Json Message::::Person:::: " + person);
    }
}
