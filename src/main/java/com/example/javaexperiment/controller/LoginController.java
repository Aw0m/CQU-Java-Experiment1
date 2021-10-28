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
public class LoginController {
    @Autowired
    private MongoOperations mongoOperations = Utilities.GetMongoTemplate();

    @GetMapping(value = "/signup")
    public String signUp(String userName, String password) {
        if (mongoOperations.findById(userName, User.class) != null) {
            return "用户名已被注册";
        }

        //* 将password通过base64加密之后再存储
        String encodedPassword = Utilities.encodeBase64Password(password);
        User user = new User(userName, encodedPassword, false);
        mongoOperations.insert(user);
        return "ok";
    }

    @GetMapping(value = "/login")
    public String login(String userName, String password) {
        User user = mongoOperations.findById(userName, User.class);
        if (user == null) {
            return "user name not found";
        }

        String decodedPassword = Utilities.decodeBase64Password(user.getPassword());
        if (decodedPassword.equals(password)) {
            return "password right!";
        }
        return "password not right";
    }

    // 没啥用，只是用来测试一下罢了
    @GetMapping(value = "test")
    public String sayHello() {
        return "Hello!";
    }
}
