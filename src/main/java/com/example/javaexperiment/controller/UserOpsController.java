package com.example.javaexperiment.controller;

import com.example.javaexperiment.models.User;
import com.example.javaexperiment.utils.Utilities;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoOperations;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @Author: Awom
 * @Date: 2021/10/23 0:08
 */

@RestController
@RequestMapping(value = "/user")
public class UserOpsController {
    @Autowired
    private MongoOperations mongoOperations = Utilities.GetMongoTemplate();

    @PostMapping(value = "/signup")
    public String signUp(String userName, String password) {
        if (mongoOperations.findById(userName, User.class) != null) {
            return "null";
        }
        //* 密码的保存需要重新写一下
        User user = new User(userName, password, false);
        mongoOperations.insert(user);
        return "ok";
    }

    // 没啥用，只是用来测试一下罢了
    @GetMapping(value = "test")
    public String sayHello() {
        return "Hello!";
    }
}
