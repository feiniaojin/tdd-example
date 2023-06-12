package com.feiniaojin.tdd.example.mapper;

import com.feiniaojin.tdd.example.model.CmsArticle;

import java.util.List;

public interface CmsArticleMapper {
    int deleteByPrimaryKey(Long id);

    int insert(CmsArticle record);

    CmsArticle selectByPrimaryKey(Long id);

    List<CmsArticle> selectAll();

    int updateByPrimaryKey(CmsArticle record);
}