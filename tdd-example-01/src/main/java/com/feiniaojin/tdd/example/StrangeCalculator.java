package com.feiniaojin.tdd.example;

public class StrangeCalculator {
    public int calculate(int input) {

        if (input >= 100) {
            //第二次迭代时，大于等于100的区间还是走老逻辑
//            return doGivenGreaterThan0(input);
            return doGivenGreaterThanOrEquals100(input);
        } else if (input > 0) {
            //第二次迭代的业务逻辑
            return doGivenGreaterThan0AndLessThan100(input);
        } else if (input < 0) {
            return doGivenLessThan0(input);
        } else {
            return doGivenEquals0(input);
        }
    }

    private int doGivenGreaterThan0AndLessThan100(int input) {
        return input * input;
    }

    private int doGivenEquals0(int input) {
        return 0;
    }

    private int doGivenLessThan0(int input) {
        return input + 1;
    }

    private int doGivenGreaterThanOrEquals100(int input) {
        return input - 1;
    }
}
