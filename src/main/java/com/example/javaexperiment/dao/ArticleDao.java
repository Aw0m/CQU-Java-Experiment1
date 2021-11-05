package com.example.javaexperiment.dao;

import com.example.javaexperiment.models.Article;
import com.example.javaexperiment.utils.Utilities;
import org.springframework.data.mongodb.core.MongoOperations;

/**
 * @Author: Awom
 * @Date: 2021/11/5 16:35
 */

public abstract class ArticleDao {
    private static final MongoOperations mongoOperations = Utilities.GetMongoTemplate();

    public static String addArticle(String writerName, String articleTitle, String articleContent, Integer articlesNum) {
        Article article = new Article(writerName, articleTitle, articleContent, articlesNum);
        mongoOperations.insert(article);
        return "ok";
    }
}
