package com.example.todoapp.exceptions;

import lombok.Data;
import org.springframework.http.HttpStatus;

@Data
public class ToDoExceptions extends RuntimeException {
    private String message;
    private HttpStatus status;

    public ToDoExceptions(String message, HttpStatus status) {
        super(message);
        this.message = message;
        this.status = status;
    }
}
