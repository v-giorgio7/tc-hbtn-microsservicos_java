package com.example.calculator.controller;

import com.example.calculator.exception.NullNumberException;
import com.example.calculator.exception.NumberDividedPerZeroException;
import com.example.calculator.model.Calculator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.time.LocalDate;

@RestController
@RequestMapping(value = "/calculator")
public class CalculatorController {

    Calculator calculator = new Calculator();

    @GetMapping("/welcome")
    public String messageWelcome() {
        return "Bem vindo à CALCULATOR API REST.";
    }

    @GetMapping("/addNumbers")
    public String addNumbers(@RequestParam(name = "number1") Double n1,
                             @RequestParam(name = "number2") Double n2) {
        try {
            String sum = String.valueOf(calculator.sum(n1, n2));
            return sum;
        } catch (NullNumberException e) {
            System.out.println(e.getMessage());
            return null;
        }
    }

    @GetMapping("/subNumbers")
    public String subNumbers(@RequestParam(name = "number1") Double n1,
                             @RequestParam(name = "number2") Double n2) {
        try {
            String sub = String.valueOf(calculator.sub(n1, n2));
            return sub;
        } catch (NullNumberException e) {
            System.out.println(e.getMessage());
            return null;
        }
    }

    @GetMapping("/divideNumbers")
    public String divideNumbers(@RequestParam(name = "number1") Double n1,
                                @RequestParam(name = "number2") Double n2) {
        try {
            String div = String.valueOf(calculator.divide(n1, n2));
            return div;
        } catch (NullNumberException | NumberDividedPerZeroException e) {
            System.out.println(e.getMessage());
            return null;
        }
    }

    @GetMapping("/factorial")
    public String factorial(@RequestParam(name = "factorial") Integer factorial) {
        try {
            String fact = String.valueOf(calculator.factorial(factorial));
            return fact;
        } catch (NullNumberException e) {
            System.out.println(e.getMessage());
            return null;
        }
    }

    @GetMapping("/calculeDayBetweenDate")
    public String calculeDayBetweenDate(
            @RequestParam("localDate1") @DateTimeFormat(iso = DateTimeFormat.ISO.DATE) LocalDate localDate1,
            @RequestParam("localDate2") @DateTimeFormat(iso = DateTimeFormat.ISO.DATE) LocalDate localDate2) {
        try {
            String diffInDays = String.valueOf(calculator.calculeDayBetweenDate(localDate1, localDate2));
            return diffInDays;
        } catch (NullNumberException e) {
            System.out.println(e.getMessage());
            return null;
        }
    }

    @GetMapping("/integerToBinary")
    public String integerToBinary(@RequestParam(name = "number1") Integer n1) {
        try {
            String binaryNum = String.valueOf(calculator.integerToBinary(n1));
            return binaryNum;
        } catch (NullNumberException e) {
            System.out.println(e.getMessage());
            return null;
        }
    }

    @GetMapping("/integerToHexadecimal")
    public String integerToHexadecimal(@RequestParam(name = "number1") Integer n1) {
        try {
            String hexNum = String.valueOf(calculator.integerToHexadecimal(n1));
            return hexNum;
        } catch (NullNumberException e) {
            System.out.println(e.getMessage());
            return null;
        }
    }
}
