package com.example.javaexperiment.utils;

import com.mongodb.client.MongoClients;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.SimpleMongoClientDatabaseFactory;

/**
 * @Author: Awom
 * @Date: 2021/10/22 23:53
 */

public abstract class Utilities {
    public static MongoTemplate GetMongoTemplate() {
        return new MongoTemplate(new SimpleMongoClientDatabaseFactory(MongoClients.create(), "myDB1"));
    }
}
