package com.feiniaojin.tdd.example;

import com.feiniaojin.tdd.example.dto.CreateDraftCmd;
import com.feiniaojin.tdd.example.gateway.IdServiceGateway;
import com.feiniaojin.tdd.example.mapper.CmsArticleMapper;
import com.feiniaojin.tdd.example.model.CmsArticle;
import com.feiniaojin.tdd.example.service.ArticleService;
import com.feiniaojin.tdd.example.service.ArticleServiceImpl;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mockito;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import javax.annotation.Resource;

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.NONE,
        classes = {ArticleServiceImpl.class})
@ExtendWith(SpringExtension.class)
public class ArticleServiceImplTest {

    @Resource
    private ArticleService articleService;

    @MockBean
    IdServiceGateway idServiceGateway;

    @MockBean
    private CmsArticleMapper cmsArticleMapper;

    @Test
    public void testCreateDraft() {

        Mockito.when(idServiceGateway.nextId()).thenReturn("123");
        Mockito.when(cmsArticleMapper.insert(Mockito.any())).thenReturn(1);

        CreateDraftCmd createDraftCmd = new CreateDraftCmd();
        createDraftCmd.setTitle("test-title");
        createDraftCmd.setContent("test-content");
        articleService.createDraft(createDraftCmd);

        Mockito.verify(idServiceGateway, Mockito.times(1)).nextId();
        Mockito.verify(cmsArticleMapper, Mockito.times(1)).insert(Mockito.any());
    }

    @Test
    public void testGetById() {
        CmsArticle article = new CmsArticle();
        article.setId(1L);
        article.setTitle("testGetById");
        Mockito.when(cmsArticleMapper.selectByPrimaryKey(Mockito.any())).thenReturn(article);

        CmsArticle byId = articleService.getById(1L);

        Assertions.assertNotNull(byId);
        Assertions.assertEquals(1L,byId.getId());
        Assertions.assertEquals("testGetById",byId.getTitle());
    }
}
