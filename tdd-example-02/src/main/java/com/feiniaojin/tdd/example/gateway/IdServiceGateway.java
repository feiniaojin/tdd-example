package com.feiniaojin.tdd.example.gateway;

import org.springframework.stereotype.Component;

import java.util.UUID;

@Component
public class IdServiceGateway {

    public String nextId() {
        return UUID.randomUUID().toString().replace("-", "");
    }
}
