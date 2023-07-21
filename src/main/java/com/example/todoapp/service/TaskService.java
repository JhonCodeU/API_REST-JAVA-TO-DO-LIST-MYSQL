package com.example.todoapp.service;

import com.example.todoapp.exceptions.ToDoExceptions;
import com.example.todoapp.mapper.TaskInDTOToTask;
import com.example.todoapp.persistence.entity.Task;
import com.example.todoapp.persistence.entity.TaskStatus;
import com.example.todoapp.persistence.repository.TaskRepository;
import com.example.todoapp.service.dto.TaskInDTO;
import jakarta.transaction.Transactional;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class TaskService {

    private final TaskRepository repository;
    private  final TaskInDTOToTask mapper;

    public TaskService(TaskRepository repository, TaskInDTOToTask mapper) {
        this.repository = repository;
        this.mapper = mapper;
    }

    public Task createTask(TaskInDTO taskDTO) {
        Task task = this.mapper.map(taskDTO);
        this.repository.save(task);
        return task;
    }
    public List<Task> getAllTasks() {
        return this.repository.findAll();
    }

    public List<Task> getAllTasksByStatus(TaskStatus status) {
        return this.repository.findAllByStatus(status);
    }

    @Transactional
    public void updateTaskAsDone(Long id) {
        Optional<Task> optionalTask =  this.repository.findById(id);

        if (optionalTask.isEmpty()) {
            throw new ToDoExceptions("Task not found", HttpStatus.NOT_FOUND);
        }

        this.repository.markTaskAsDone(id);
    }

    public void deleteTask(Long id) {
        Optional<Task> optionalTask =  this.repository.findById(id);
        if (optionalTask.isEmpty()) {
            throw new ToDoExceptions("Task not found", HttpStatus.NOT_FOUND);
        }

        this.repository.deleteById(id);
    }
}
