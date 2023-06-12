package com.feiniaojin.tdd.example.service;

import com.feiniaojin.tdd.example.dto.CreateDraftCmd;
import com.feiniaojin.tdd.example.model.CmsArticle;

public interface ArticleService {
    void createDraft(CreateDraftCmd cmd);

    CmsArticle getById(Long id);
}
