package com.example.calculator.model;

import com.example.calculator.exception.NullNumberException;
import com.example.calculator.exception.NumberDividedPerZeroException;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.time.Duration;
import java.time.LocalDate;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class CalculatorTest {

    Calculator calculator;

    @BeforeEach
    public void setup(){
        calculator = new Calculator();
    }

    @Test
    public void sumTest() {
        Double number1 = 10.0;
        Double number2 = 20.0;
        assertEquals(number1 + number2,
                calculator.sum(number1, number2),
                "Deve retornar a soma dos numeros");
    }

    @Test
    public void numbersNullSumTest() {
        Double number1 = 10.0;
        Double number2 = null;
        Integer number2Int = null;
        LocalDate date1 = LocalDate.of(2020, 12,12);
        LocalDate date2 = null;

        assertThrows(NullNumberException.class, () -> {
            calculator.sum(number1, number2);
        }, "Deve retornar NullNumberException");

        assertThrows(NullNumberException.class, () -> {
            calculator.sub(number1, number2);
        }, "Deve retornar NullNumberException");

        assertThrows(NullNumberException.class, () -> {
            calculator.divide(number1, number2);
        }, "Deve retornar NullNumberException");

        assertThrows(NullNumberException.class, () -> {
            calculator.factorial(number2Int);
        }, "Deve retornar NullNumberException");

        assertThrows(NullNumberException.class, () -> {
            calculator.calculeDayBetweenDate(date1, date2);
        }, "Deve retornar NullNumberException");

        assertThrows(NullNumberException.class, () -> {
            calculator.integerToBinary(number2Int);
        }, "Deve retornar NullNumberException");

        assertThrows(NullNumberException.class, () -> {
            calculator.integerToHexadecimal(number2Int);
        }, "Deve retornar NullNumberException");
    }

    @Test
    void subTest() {
        Double number1 = 10.0;
        Double number2 = 20.0;
        assertEquals(number2 - number1,
                calculator.sub(number1, number2),
                "Deve retornar a subtração dos numeros");
    }

    @Test
    void divideTest() {
        Double number1 = 10.0;
        Double number2 = 20.0;
        assertEquals(number2 / number1,
                calculator.divide(number2, number1),
                "Deve retornar a divisao dos numeros");
    }

    @Test
    public void divisionByZeroTest() {
        Double number1 = 10.0;
        Double number2 = 0.0;
        assertThrows(NumberDividedPerZeroException.class, () -> {
            calculator.divide(number1, number2);
        }, "Deve retornar NumberDividedPerZeroException");
    }

    @Test
    void factorialTest() {
        Integer number1 = 5;
        Integer factorialResult = 1;

        for (int i = 1; i <= number1; i++) {
            factorialResult *= i;
        }

        assertEquals(factorialResult,
                calculator.factorial(number1),
                "Deve retornar o fatorial do numero");

        assertEquals(120,
                calculator.factorial(number1),
                "Deve retornar o fatorial do numero");
    }

    @Test
    void integerToBinaryTest() {
        Integer number1 = 20;
        Integer number2 = 5;

        assertEquals(10100,
                calculator.integerToBinary(number1),
                "Deve retornar o numero em notaçao binaria");

        assertEquals(101,
                calculator.integerToBinary(number2),
                "Deve retornar o numero em notaçao binaria");
    }

    @Test
    void integerToHexadecimalTest() {
        Integer number1 = 170;
        Integer number2 = 55;

        assertEquals("aa",
                calculator.integerToHexadecimal(number1),
                "Deve retornar o numero em notaçao hexadecimal");

        assertEquals("37",
                calculator.integerToHexadecimal(number2),
                "Deve retornar o numero em notaçao hexadecimal");
    }

    @Test
    void calculeDayBetweenDateTest() {
        LocalDate date1 = LocalDate.of(2020, 3, 14);
        LocalDate date2 = LocalDate.of(2021, 3, 14);

        assertEquals(365,
                calculator.calculeDayBetweenDate(date1, date2),
                "Deve retornar a diferença das datas em dias");

    }
}
