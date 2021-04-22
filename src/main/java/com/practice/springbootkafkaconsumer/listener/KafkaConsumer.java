package com.practice.springbootkafkaconsumer.listener;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.practice.springbootkafkaconsumer.dao.PersonDao;
import com.practice.springbootkafkaconsumer.model.Person;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;

@Service
public class KafkaConsumer {

    @Autowired
    private PersonDao personDao;

    /*@KafkaListener(topics = "KafkaExample", groupId = "group_id")
    public void consume(String message){
        System.out.println("Consumed message from Topic:::" + message);
    }*/

    //@KafkaListener(topics = "KafkaExampleJson", groupId = "group_json",
    @KafkaListener(
            topics = "${spring.kafka.consumer.topic}",
            groupId = "${spring.kafka.consumer.group-id}")
    public void consumeJson(String person){
        ObjectMapper obj = new ObjectMapper();
        Person person1 = null;
        try {
            person1 = obj.readValue(person,Person.class);
            Person person2 = personDao.savePerson(person1);
            //producer.send(person2);
        }catch (Exception e){

        }
        System.out.println("Consumed Json Message::::Person:::: " + person);
    }
}
