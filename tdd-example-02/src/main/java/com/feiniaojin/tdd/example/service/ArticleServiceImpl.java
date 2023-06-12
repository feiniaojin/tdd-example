package com.feiniaojin.tdd.example.service;

import com.feiniaojin.tdd.example.dto.CreateDraftCmd;
import com.feiniaojin.tdd.example.gateway.IdServiceGateway;
import com.feiniaojin.tdd.example.mapper.CmsArticleMapper;
import com.feiniaojin.tdd.example.model.CmsArticle;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.Date;

@Service
public class ArticleServiceImpl implements ArticleService {

    @Resource
    private CmsArticleMapper mapper;

    @Resource
    private IdServiceGateway idServiceGateway;

    @Override
    public void createDraft(CreateDraftCmd cmd) {

        CmsArticle article = new CmsArticle();
        article.setArticleId(idServiceGateway.nextId());
        article.setContent(cmd.getContent());
        article.setTitle(cmd.getTitle());
        article.setPublishState(0);
        article.setVersion(1L);
        article.setCreatedTime(new Date());
        article.setModifiedTime(new Date());
        article.setDeleted(0);
        mapper.insert(article);
    }

    @Override
    public CmsArticle getById(Long id) {
        return mapper.selectByPrimaryKey(id);
    }
}
