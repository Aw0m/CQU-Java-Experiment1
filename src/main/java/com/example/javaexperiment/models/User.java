package com.example.javaexperiment.models;

import lombok.Data;
import org.springframework.data.mongodb.core.mapping.MongoId;

import java.util.List;

/**
 * @Author: Awom
 * @Date: 2021/10/22 23:23
 */

@Data
public class User {
    @MongoId
    private String userName;
    private String password;
    private Boolean admin;

    private Integer articlesNum;
    private List<String> articleList;

    public User(String userName, String password, Boolean admin) {
        this.userName = userName;
        this.password = password;
        this.admin = admin;
        this.articlesNum = 0;
    }
}
