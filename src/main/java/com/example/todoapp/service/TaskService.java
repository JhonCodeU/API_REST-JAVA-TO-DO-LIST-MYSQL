package com.example.todoapp.service;

import com.example.todoapp.exceptions.ToDoExceptions;
import com.example.todoapp.mapper.TaskInDTOToTask;
import com.example.todoapp.persistence.entity.Task;
import com.example.todoapp.persistence.entity.TaskStatus;
import com.example.todoapp.persistence.repository.TaskRepository;
import com.example.todoapp.service.dto.TaskInDTO;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

@Service
public class TaskService {

    @Autowired
    private final TaskRepository repository;
    private  final TaskInDTOToTask mapper;

    public TaskService(TaskRepository repository, TaskInDTOToTask mapper) {
        this.repository = repository;
        this.mapper = mapper;
    }

    public Task createTask(TaskInDTO taskDTO) {
        Task task = this.mapper.map(taskDTO);

        return this.repository.save(task);
    }
    public List<Task> getAllTasks() {
        List<Task> tasks = this.repository.findAll();
        if (tasks.isEmpty()) {
            throw new ToDoExceptions("No tasks found", HttpStatus.NOT_FOUND);
        }
        return tasks;
    }

    public Task getTaskById(Long id) {
        Optional<Task> optionalTask =  this.repository.findById(id);
        if (optionalTask.isEmpty()) {
            throw new ToDoExceptions("Task not found", HttpStatus.NOT_FOUND);
        }
        return optionalTask.get();
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

        this.repository.markTaskAsDone(id, TaskStatus.ON_TIME);
    }

    public void deleteTask(Long id) {
        Optional<Task> optionalTask =  this.repository.findById(id);
        if (optionalTask.isEmpty()) {
            throw new ToDoExceptions("Task not found", HttpStatus.NOT_FOUND);
        }

        this.repository.deleteById(id);
    }
}
