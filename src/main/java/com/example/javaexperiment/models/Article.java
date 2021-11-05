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
    private String writerName;
    private String articleTitle;
    private String articleContent;
    private Date createTime;
    private Date updateTime;
    private Integer visitedNum;

    private List<Comment> commentList;
    private Integer commentsNum;

    public Article(String articleID, String articleTitle, String articleContent, String writerName) {
        this.articleID = articleID;
        this.writerName = writerName;
        this.articleContent = articleContent;
        this.articleTitle = articleTitle;
        this.createTime = new Date(System.currentTimeMillis());
        this.updateTime = new Date(System.currentTimeMillis());
        this.visitedNum = 0;
        this.commentsNum = 0;
    }
}
