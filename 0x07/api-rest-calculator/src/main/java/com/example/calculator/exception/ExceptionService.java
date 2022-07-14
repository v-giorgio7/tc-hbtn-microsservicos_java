package com.example.calculator.exception;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestController;

import java.util.Date;

@ControllerAdvice
@RestController
public class ExceptionService {

    @ExceptionHandler(NullNumberException.class)
    public ResponseEntity<NullNumberException> handleNullNumberException (NullNumberException e) {
        CalculatorErrorResponse errorResponse = new CalculatorErrorResponse(
                HttpStatus.BAD_REQUEST.value(),
                e.getMessage(),
                new Date());

        return new ResponseEntity(errorResponse, HttpStatus.BAD_REQUEST);
    }

    @ExceptionHandler(NumberDividedPerZeroException.class)
    public ResponseEntity<NumberDividedPerZeroException> handleNullNumberException (
            NumberDividedPerZeroException e) {
        CalculatorErrorResponse errorResponse = new CalculatorErrorResponse(
                HttpStatus.BAD_REQUEST.value(),
                e.getMessage(),
                new Date());

        return new ResponseEntity(errorResponse, HttpStatus.BAD_REQUEST);
    }
}
