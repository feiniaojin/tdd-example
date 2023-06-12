package com.feiniaojin.tdd.example;

import com.feiniaojin.tdd.example.mapper.CmsArticleMapper;
import com.feiniaojin.tdd.example.model.CmsArticle;
import com.feiniaojin.tdd.example.service.ArticleServiceImpl;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import javax.annotation.Resource;
import java.util.Date;

@ExtendWith(SpringExtension.class)
@SpringBootTest
@AutoConfigureTestDatabase
public class CmsArticleMapperTest {

    @Resource
    private CmsArticleMapper mapper;

    @Test
    public void testInsert() {
        CmsArticle article = new CmsArticle();
        article.setId(0L);
        article.setArticleId("ABC123");
        article.setContent("content");
        article.setTitle("title");
        article.setVersion(1L);
        article.setModifiedTime(new Date());
        article.setDeleted(0);
        article.setPublishState(0);
        int inserted = mapper.insert(article);
        Assertions.assertEquals(1, inserted);
    }

    @Test
    public void testUpdateByPrimaryKey() {
        CmsArticle article = new CmsArticle();
        article.setId(1L);
        article.setArticleId("ABC123");
        article.setContent("content");
        article.setTitle("title");
        article.setVersion(1L);
        article.setModifiedTime(new Date());
        article.setDeleted(0);
        article.setPublishState(0);
        int updated = mapper.updateByPrimaryKey(article);
        Assertions.assertEquals(1, updated);
    }

    @Test
    public void testSelectByPrimaryKey() {
        CmsArticle article = mapper.selectByPrimaryKey(2L);
        Assertions.assertNotNull(article);
        Assertions.assertNotNull(article.getTitle());
        Assertions.assertNotNull(article.getContent());
    }
}
