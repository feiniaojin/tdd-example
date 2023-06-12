package com.feiniaojin.tdd.example;

import com.feiniaojin.tdd.example.gateway.IdServiceGateway;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;


public class IdServiceGatewayTest {

    IdServiceGateway gateway = new IdServiceGateway();

    @Test
    public void testNextId() {
        String s = gateway.nextId();
        Assertions.assertNotNull(s);
    }
}
