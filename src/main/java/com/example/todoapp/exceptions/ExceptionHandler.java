package com.example.todoapp.exceptions;

import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

@ControllerAdvice
public class ExceptionHandler extends ResponseEntityExceptionHandler {
    @org.springframework.web.bind.annotation.ExceptionHandler(value = {ToDoExceptions.class})
    protected org.springframework.http.ResponseEntity<Object> handleConflict(ToDoExceptions ex) {
        return new org.springframework.http.ResponseEntity<>(ex.getMessage(), ex.getStatus());
    }
}
