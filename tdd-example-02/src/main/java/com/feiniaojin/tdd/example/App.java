package com.feiniaojin.tdd.example;

import com.feiniaojin.gracefulresponse.EnableGracefulResponse;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * Hello world!
 */

@SpringBootApplication
@MapperScan("com.feiniaojin.tdd.example.mapper")
@EnableGracefulResponse
public class App {
    public static void main(String[] args) {
        SpringApplication.run(App.class, args);
    }
}
