package com.example.javaexperiment.controller;

import com.example.javaexperiment.service.PublishService;
import com.example.javaexperiment.utils.JWTUtils;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;

/**
 * @Author: Awom
 * @Date: 2021/10/23 0:08
 */

@RestController
@RequestMapping("/articles")
public class PublishController {
    static HashMap<String, String> tokenInfo;
    static PublishService publishService = new PublishService();

    @GetMapping("/new_article")
    public String newArticle(@RequestHeader(value = "Authorization", required = false) String token, String articleTitle, String articleContent) {
        tokenInfo = JWTUtils.verifyToken(token);
        if ("false".equals(tokenInfo.get("tokenJudge"))) {
            return null;
        }
        return publishService.toNewArticle(articleTitle, articleContent, tokenInfo.get("userName"));
    }

    @GetMapping("/delete_article")
    public String deleteArticle(@RequestHeader(value = "Authorization", required = false) String token, String articleID) {
        tokenInfo = JWTUtils.verifyToken(token);
        if ("false".equals(tokenInfo.get("tokenJudge"))) {
            return null;
        }
        return publishService.toDeleteArticle(articleID, tokenInfo.get("userName"));
    }
}
