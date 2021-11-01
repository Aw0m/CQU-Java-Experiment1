package com.example.javaexperiment.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @Author: Awom
 * @Date: 2021/10/23 0:08
 */

@RestController
@RequestMapping("/articles")
public class PublishController {
    @GetMapping("/new_article")
    public String newArticle(String articleContent) {

    }

    @GetMapping("/delete_article")
    public String deleteArticle(String articleID) {

    }
}
