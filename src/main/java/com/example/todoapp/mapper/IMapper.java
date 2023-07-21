package com.example.todoapp.mapper;

public interface IMapper <I, O>{
    O map(I input);
}
