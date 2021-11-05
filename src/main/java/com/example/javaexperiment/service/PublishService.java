package com.example.javaexperiment.service;

import com.example.javaexperiment.dao.ArticleDao;
import com.example.javaexperiment.dao.UserDao;
import com.example.javaexperiment.models.Article;
import com.example.javaexperiment.models.User;

import java.util.List;

/**
 * @Author: Awom
 * @Date: 2021/10/28 16:22
 */
public class PublishService {
    public String toNewArticle(String articleTile, String articleContent, String userName) {
        User user = UserDao.retrieveUser(userName);
        String res = ArticleDao.addArticle(user.getUserName(), articleTile, articleContent, user.getArticlesNum());
        user.setArticlesNum(user.getArticlesNum() + 1);
        UserDao.saveUser(user);
        return res;
    }

    public String toDeleteArticle(String articleContent, String userName) {
        return null;
    }

    public List<Article> toShowAllArticle() {
        return ArticleDao.getAllArticle();
    }
}
