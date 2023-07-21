package com.example.todoapp.controllers;

import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/test")
public class TestController {

    @GetMapping
    public String getAll() {
        return "All tests";
    }

    @PostMapping
    public String create(@RequestBody String test) {
        return "Create test" + test;
    }
}
