package com.example.user.exception;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestController;

import java.util.Date;

@ControllerAdvice
@RestController
public class ExceptionService {

    @ExceptionHandler(UserIdException.class)
    public ResponseEntity<UserIdException> handleIdException(UserIdException e) {
        UserErrorResponse user = new UserErrorResponse(
                HttpStatus.BAD_REQUEST.value(),
                "You have entered ID " + e.getMessage() + " invalid.",
                new Date());

        return new ResponseEntity(user, HttpStatus.BAD_REQUEST);
    }

    @ExceptionHandler(UserNameException.class)
    public ResponseEntity<UserNameException> handleUserNameException(UserNameException e) {
        UserErrorResponse user = new UserErrorResponse(
                HttpStatus.BAD_REQUEST.value(),
                "You have entered UserName " + e.getMessage() + " invalid.",
                new Date());

        return new ResponseEntity(user, HttpStatus.BAD_REQUEST);
    }

    @ExceptionHandler(CPFException.class)
    public ResponseEntity<CPFException> handleCPFException(CPFException e){
        UserErrorResponse user = new UserErrorResponse(
                HttpStatus.BAD_REQUEST.value(),
                "You have entered CPF " + e.getMessage() + " invalid.",
                new Date());

        return new ResponseEntity(user, HttpStatus.BAD_REQUEST);
    }

}
