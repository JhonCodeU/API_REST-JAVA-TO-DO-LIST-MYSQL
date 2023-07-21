package com.example.todoapp.persistence.entity;

import jakarta.persistence.*;
import lombok.Data;

import java.time.LocalDateTime;

@Data
@Entity
@Table(name = "tasks")
public class Task {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;
    private String title;
    private String description;
    private boolean finished;
    private LocalDateTime createdDate;
    private LocalDateTime finishedDate;
    private TaskStatus status;
}
