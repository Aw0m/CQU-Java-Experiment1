package com.example.javaexperiment.service;

import com.example.javaexperiment.dao.ArticleDao;
import com.example.javaexperiment.dao.UserDao;
import com.example.javaexperiment.models.User;

/**
 * @Author: Awom
 * @Date: 2021/10/28 16:22
 */
public class PublishService {
    public String toNewArticle(String articleTile, String articleContent, String userName) {
        User user = UserDao.retrieveUser(userName);
        ArticleDao.addArticle(user.getUserName(), articleTile, articleContent, user.getArticlesNum());
        user.setArticlesNum(user.getArticlesNum() + 1);
        return null;
    }

    public String toDeleteArticle(String articleContent, String userName) {
        return null;
    }
}
