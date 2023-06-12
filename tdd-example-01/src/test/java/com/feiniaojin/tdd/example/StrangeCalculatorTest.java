package com.feiniaojin.tdd.example;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class StrangeCalculatorTest {

    private StrangeCalculator strangeCalculator;


    @BeforeEach
    public void setup() {
        strangeCalculator = new StrangeCalculator();
    }

//    @Test
//    @DisplayName("入参大于0，将其减1并返回")
//    public void givenGreaterThan0() {
//        //大于0的入参
//        int input = 1;
//        int expected = 0;
//        //实际计算
//        int result = strangeCalculator.calculate(input);
//        //断言确认是否减1
//        Assertions.assertEquals(expected, result);
//    }

    @Test
    @DisplayName("入参小于0，将其加1并返回")
    public void givenLessThan0() {
        //小于0的入参
        int input = -1;
        int expected = 0;
        //实际计算
        int result = strangeCalculator.calculate(input);
        //断言确认是否减1
        Assertions.assertEquals(expected, result);
    }

    @Test
    @DisplayName("入参等于0，直接返回")
    public void givenEquals0() {
        //等于0的入参
        int input = 0;
        int expected = 0;

        //实际计算
        int result = strangeCalculator.calculate(input);
        //断言确认是否等于0
        Assertions.assertEquals(expected, result);
    }

    @Test
    @DisplayName("入参大于0且小于100，计算其平方")
    public void givenGreaterThan0AndLessThan100() {
        //于0且小于100的入参
        int input = 3;
        int expected = 9;
        //实际计算
        int result = strangeCalculator.calculate(input);
        //断言确认是否计算了平方
        Assertions.assertEquals(expected, result);
    }

    @Test
    @DisplayName("入参大于等于100，计算其减1的值")
    public void givenGreaterThanOrEquals100() {
        //于0且小于100的入参
        int input = 100;
        int expected = 99;
        //实际计算
        int result = strangeCalculator.calculate(input);
        //断言确认是否计算了平方
        Assertions.assertEquals(expected, result);
    }
}
