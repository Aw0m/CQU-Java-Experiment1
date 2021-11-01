package com.example.javaexperiment.service;

import com.example.javaexperiment.dao.UserDao;
import com.example.javaexperiment.models.User;
import com.example.javaexperiment.utils.JWTUtils;
import com.example.javaexperiment.utils.Utilities;

/**
 * @Author: Awom
 * @Date: 2021/10/28 16:20
 */
public class LoginService {
    /*
     * 之后把下面出现错误的情况都改为抛出异常
     */
    public String toLogin(String userName, String password) {
        User user = UserDao.retrieveUser(userName);
        if (user == null) {
            return "user name not found";
        }

        String decodedPassword = Utilities.decodeBase64Password(user.getPassword());
        if (decodedPassword.equals(password)) {
            return JWTUtils.createToken(user.getUserName(), user.getPassword(), 1000*3600*3);
        }
        return "password not right";
    }

    public String toSignUp(String userName, String password) {
        User user = UserDao.retrieveUser(userName);
        if (user != null) {
            return "user already exists";
        }

        String encodedPassword = Utilities.encodeBase64Password(password);
        user = new User(userName, encodedPassword, false);
        if (UserDao.createUser(user)) {
            return JWTUtils.createToken(user.getUserName(), user.getPassword(), 1000*3600*3);
        }
        return "error";
    }
}
