package com.example.javaexperiment.models;

import lombok.Data;

import java.util.Date;

/**
 * @Author: Awom
 * @Date: 2021/10/22 23:27
 */

@Data
public class Comment {
    private String commenterName;
    private String commentText;
    private Date commentTime;

    public Comment(String commenterName, String commentText) {
        this.commenterName = commenterName;
        this.commentText = commentText;
        this.commentTime = new Date(System.currentTimeMillis());
    }
}
