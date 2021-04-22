package com.practice.springbootkafkaconsumer.dao;

import com.practice.springbootkafkaconsumer.model.Person;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.stereotype.Service;

@Service
public class PersonDao {

    @Autowired
    private MongoTemplate mongoTemplate;

    public Person savePerson(Person person){
        return mongoTemplate.save(person);
    }
}
