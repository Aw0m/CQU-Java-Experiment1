package com.example.javaexperiment.controller;

import com.example.javaexperiment.models.User;
import com.example.javaexperiment.service.LoginService;
import com.example.javaexperiment.utils.Utilities;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoOperations;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;

/**
 * @Author: Awom
 * @Date: 2021/10/23 0:08
 */

@RestController
@RequestMapping(value = "/users")
public class LoginController {
    static final LoginService loginService = new LoginService();

    @GetMapping(value = "/signup")
    public HashMap<String, String> signUp(String userName, String password) {
        String res = loginService.toSignUp(userName, password);

        if ("error".equals(res)) {
            HashMap<String, String> wrongResult = new HashMap<>(1);
            wrongResult.put("result", "error");
            return wrongResult;
        }

        if ("user already exists".equals(res)) {
            //* 返回结果为用户已经存在 {"result": "exist"}
            HashMap<String, String> wrongResult = new HashMap<>(1);
            wrongResult.put("result", "exist");
            return wrongResult;
        }

        //* 以上两种情况都不满足的时候，res的值为token
        HashMap<String, String> tokenResult = new HashMap<>(2);
        tokenResult.put("result", "ok");
        tokenResult.put("token", res);
        return tokenResult;
    }

    @GetMapping(value = "/login")
    public HashMap<String, String> login(String userName, String password) {
        String res = loginService.toLogin(userName, password);

        if ("user name not found".equals(res)) {
            HashMap<String, String> wrongResult = new HashMap<>(1);
            wrongResult.put("result", "not found");
            return wrongResult;
        }

        if ("password not right".equals(res)) {
            HashMap<String, String> wrongResult = new HashMap<>(1);
            wrongResult.put("result", "not right");
            return wrongResult;
        }

        //* 以上两种情况都不满足的时候，res的值为token
        HashMap<String, String> tokenResult = new HashMap<>(2);
        tokenResult.put("result", "ok");
        tokenResult.put("token", res);
        return tokenResult;
    }

    // 没啥用，只是用来测试一下罢了
    @GetMapping(value = "test")
    public String sayHello() {
        return "Hello!";
    }
}
