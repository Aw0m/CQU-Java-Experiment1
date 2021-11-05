package com.example.javaexperiment.controller;

import com.example.javaexperiment.models.Article;
import com.example.javaexperiment.service.PublishService;
import com.example.javaexperiment.utils.JWTUtils;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;

/**
 * @Author: Awom
 * @Date: 2021/10/23 0:08
 */

@RestController
@CrossOrigin
@RequestMapping("/articles")
public class PublishController {
    static HashMap<String, String> tokenInfo;
    static PublishService publishService = new PublishService();

    @PostMapping("/new_article")
    public String newArticle(@RequestHeader(value = "Authorization", required = false) String token,
                             @RequestParam("articleTitle") String articleTitle,
                             @RequestParam("articleContent") String articleContent) {
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

    @GetMapping("/showAll")
    public List<Article> showAllArticle(@RequestHeader(value = "Authorization", required = false) String token) {
        System.out.println("show all articles!");
        System.out.println(token);

        tokenInfo = JWTUtils.verifyToken(token);
        if ("false".equals(tokenInfo.get("tokenJudge"))) {
            return null;
        }
//        System.out.println(publishService.toShowAllArticle());
        return publishService.toShowAllArticle();
    }
}