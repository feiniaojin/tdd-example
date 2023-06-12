package com.feiniaojin.tdd.example;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.feiniaojin.tdd.example.controller.ArticleController;
import com.feiniaojin.tdd.example.dto.CreateDraftCmd;
import com.feiniaojin.tdd.example.model.CmsArticle;
import com.feiniaojin.tdd.example.service.ArticleService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mockito;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultHandlers;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.context.WebApplicationContext;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;

import javax.annotation.Resource;

@ExtendWith(SpringExtension.class)
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.MOCK,
        classes = {ArticleController.class})
@EnableWebMvc
public class ArticleControllerTest {

    @Resource
    WebApplicationContext webApplicationContext;

    MockMvc mockMvc;

    @MockBean
    ArticleService articleService;

    //初始化mockmvc
    @BeforeEach
    void setUp() {
        mockMvc = MockMvcBuilders.webAppContextSetup(webApplicationContext).build();
    }

    @Test
    void testCreateDraft() throws Exception {

        CreateDraftCmd cmd = new CreateDraftCmd();
        cmd.setTitle("test-controller-title");
        cmd.setContent("test-controller-content");

        ObjectMapper mapper = new ObjectMapper();
        String valueAsString = mapper.writeValueAsString(cmd);

        Mockito.doNothing().when(articleService).createDraft(Mockito.any());

        mockMvc.perform(MockMvcRequestBuilders
                        //访问的URL和参数
                        .post("/article/createDraft")
                        .content(valueAsString)
                        .contentType(MediaType.APPLICATION_JSON))
                //期望返回的状态码
                .andExpect(MockMvcResultMatchers.status().isOk())
                //输出请求和响应结果
                .andDo(MockMvcResultHandlers.print()).andReturn();
    }

    @Test
    void testGet() throws Exception {

        CmsArticle article = new CmsArticle();
        article.setId(1L);
        article.setTitle("testGetById");

        Mockito.when(articleService.getById(Mockito.any())).thenReturn(article);

        mockMvc.perform(MockMvcRequestBuilders
                        //访问的URL和参数
                        .get("/article/get").param("id","1"))
                //期望返回的状态码
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andExpect(MockMvcResultMatchers.jsonPath("$.id").value(1L))
                //输出请求和响应结果
                .andDo(MockMvcResultHandlers.print()).andReturn();
        
    }
}
