package com.example.javaexperiment.models;

import lombok.Data;
import org.springframework.data.mongodb.core.mapping.MongoId;

import java.util.Date;
import java.util.List;

/**
 * @Author: Awom
 * @Date: 2021/10/22 23:26
 */

@Data
public class Article {
    @MongoId
    private String articleID;
    private String articleText;
    private String writeName;
    private Date createTime;
    private Date updateTime;
    private Integer visitedNum;

    private List<Comment> commentList;
    private Integer commentsNum;

    public Article(String writeName, String articleText, Integer articlesNum) {
        this.articleID = writeName + articlesNum.toString();
        this.articleText = articleText;
        this.writeName = writeName;
        this.createTime = new Date(System.currentTimeMillis());
        this.updateTime = new Date(System.currentTimeMillis());
        this.visitedNum = 0;
        this.commentsNum = 0;
    }
}
