package com.example.calculator.exception;

public class NumberDividedPerZeroException extends ArithmeticException {

    public NumberDividedPerZeroException(String s) {
        super(s);
    }
}
