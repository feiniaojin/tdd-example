package com.feiniaojin.tdd.example.dto;

import lombok.Data;

@Data
public class CreateDraftCmd {

    private String title;
    private String content;
}
