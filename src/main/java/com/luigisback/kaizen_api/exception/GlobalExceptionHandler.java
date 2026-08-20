package com.luigisback.kaizen_api.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.bind.MethodArgumentNotValidException;

@RestControllerAdvice
public class GlobalExceptionHandler{

    @ExceptionHandler(HabitNotFoundException.class)
    @ResponseStatus(HttpStatus.NOT_FOUND)
    public  String handleHabitNotFound(HabitNotFoundException ex) {
        return ex.getMessage();
    }

    @ExceptionHandler(HabitLogAlreadyExistsException.class)
    @ResponseStatus(HttpStatus.CONFLICT)
    public String handleHabitLogAlreadyExist(HabitLogAlreadyExistsException ex){
        return ex.getMessage();
    }
    //cambiar este método a mano
    @ExceptionHandler(MethodArgumentNotValidException.class)
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    public String handleValidationException(MethodArgumentNotValidException ex) {
        return ex.getBindingResult()
                .getFieldErrors()
                .get(0)
                .getDefaultMessage();
    }




}

