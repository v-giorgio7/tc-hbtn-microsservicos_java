package com.example.calculator.model;

import com.example.calculator.exception.NullNumberException;
import com.example.calculator.exception.NumberDividedPerZeroException;

import java.time.Duration;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class Calculator {
    public Double sum(Double number1, Double number2) {
        if (number1 == null || number2 == null) {
            throw new NullNumberException("Número 1 e número 2 são obrigatórios.");
        }

        return number1 + number2;
        // validação -> throw new NullPointerException("Número 1 e número 2 são obrigatórios.");
    }

    public Double sub(Double number1, Double number2) {
        if (number1 == null || number2 == null) {
            throw new NullNumberException("Número 1 e número 2 são obrigatórios.");
        }

        return Math.max(number1, number2) - Math.min(number1, number2);
        // validação -> throw new NullPointerException("Número 1 e número 2 são obrigatórios.");
    }

    public Double divide (Double number1, Double number2)  {
        if (number1 == null || number2 == null) {
            throw new NullNumberException("Número 1 e número 2 são obrigatórios.");
        } else if (number2 == 0) {
            throw new NumberDividedPerZeroException("Divisão por zero não é permitido.");
        }

        return number1 / number2;
        // validação -> throw new NullPointerException("Número 1 e número 2 são obrigatórios.");
        // validação -> throw new ArithmeticException("Divisão por zero não é permitido.");
    }

    public Integer factorial(Integer factorial) {
        if (factorial == null) {
            throw new NullNumberException("Número é obrigatório.");
        }

        Integer factorialResult = 1;

        for (int i = 1; i <= factorial; i++) {
            factorialResult *= i;
        }

        return factorialResult;
        // validação -> throw new NullPointerException("Número é obrigatório.");
    }

    // Exemplos:
    // Integer = 1 -> Binary = 1
    // Integer = 5 -> Binary = 101
    // Integer = 20 -> Binary = 10100
    public Integer integerToBinary(Integer integer) {
        if (integer == null) {
            throw new NullNumberException("Número é obrigatório.");
        }

        return Integer.parseInt(Integer.toBinaryString(integer));
    }

    // Exemplos:
    // Integer = 1 -> Hexadecimal = "1"
    // Integer = 55 -> Hexadecimal = "37"
    // Integer = 170 -> Binary = "AA"
    public String integerToHexadecimal(Integer integer) {
        if (integer == null) {
            throw new NullNumberException("Número é obrigatório.");
        }

        return Integer.toHexString(integer);
    }

    // Exemplos
    // Date 1 = LocalDate.of(2020, 3, 15);
    // Date 2 = LocalDate.of(2020, 3, 29)
    // Total de dias = 14
    public long calculeDayBetweenDate(LocalDate date1, LocalDate date2) {
        if (date1 == null || date2 == null) {
            throw new NullNumberException("Data 1 e Data 2 são obrigatórias.");
        }

        return Math.abs(
                Duration.between(
                        date1.atStartOfDay(),
                        date2.atStartOfDay())
                        .toDays());
    }
}
