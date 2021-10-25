package com.example.javaexperiment.utils;

import com.mongodb.client.MongoClients;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.SimpleMongoClientDatabaseFactory;

import java.nio.charset.StandardCharsets;
import java.util.Base64;

/**
 * @Author: Awom
 * @Date: 2021/10/22 23:53
 */

public abstract class Utilities {
    public static MongoTemplate GetMongoTemplate() {
        return new MongoTemplate(new SimpleMongoClientDatabaseFactory(MongoClients.create(), "myDB1"));
    }

    public static String encodeBase64Password(String password) {
        return Base64.getEncoder().encodeToString(password.getBytes(StandardCharsets.UTF_8));
    }

    public static String decodeBase64Password(String base64encodedString) {
        byte[] base64decodedBytes = Base64.getDecoder().decode(base64encodedString);
        return new String(base64decodedBytes, StandardCharsets.UTF_8);
    }
}
