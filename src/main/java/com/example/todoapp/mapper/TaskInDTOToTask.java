package com.example.todoapp.mapper;

import com.example.todoapp.persistence.entity.Task;
import com.example.todoapp.persistence.entity.TaskStatus;
import com.example.todoapp.service.dto.TaskInDTO;
import org.springframework.stereotype.Component;

import java.time.LocalDateTime;

@Component
public class TaskInDTOToTask implements IMapper<TaskInDTO, Task>{
    @Override
    public Task map(TaskInDTO input) {
        Task task = new Task();
        task.setTitle(input.getTitle());
        task.setDescription(input.getDescription());
        task.setCreatedDate(LocalDateTime.now());
        task.setFinishedDate(input.getFinishedDate());
        task.setFinished(false);
        task.setStatus(TaskStatus.ON_TIME);
        return task;
    }
}
