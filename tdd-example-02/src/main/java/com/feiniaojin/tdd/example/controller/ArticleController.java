package com.feiniaojin.tdd.example.controller;

import com.feiniaojin.tdd.example.dto.CreateDraftCmd;
import com.feiniaojin.tdd.example.model.CmsArticle;
import com.feiniaojin.tdd.example.service.ArticleService;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

@RestController
@RequestMapping("/article")
public class ArticleController {

    @Resource
    private ArticleService articleService;

    @RequestMapping("/createDraft")
    public void createDraft(@RequestBody CreateDraftCmd cmd) {
        articleService.createDraft(cmd);
    }

    @RequestMapping("/get")
    public CmsArticle get(Long id) {
        CmsArticle article = articleService.getById(id);
        return article;
    }
}
