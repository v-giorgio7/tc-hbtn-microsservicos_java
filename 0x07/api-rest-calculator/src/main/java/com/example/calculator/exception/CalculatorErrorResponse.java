package com.example.calculator.exception;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class CalculatorErrorResponse {

    private int status;
    private String message;
    private Date timestamp;
}
