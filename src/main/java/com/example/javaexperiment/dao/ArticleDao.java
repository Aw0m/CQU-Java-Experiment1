package com.example.javaexperiment.dao;

import com.example.javaexperiment.models.Article;
import com.example.javaexperiment.utils.Utilities;
import org.springframework.data.mongodb.core.MongoOperations;


import java.util.List;

/**
 * @Author: Awom
 * @Date: 2021/11/5 16:35
 */

public abstract class ArticleDao {
    private static final MongoOperations mongoOperations = Utilities.GetMongoTemplate();

    public static String addArticle(String writerName, String articleTitle, String articleContent, Integer articlesNum) {
        Article article = new Article(writerName + articlesNum.toString(), articleTitle, articleContent, writerName);
        System.out.println("new article ok");
        mongoOperations.insert(article, "article");
        return "ok";
    }

    public static List<Article> getAllArticle() {
        return mongoOperations.findAll(Article.class, "article");
    }
}
