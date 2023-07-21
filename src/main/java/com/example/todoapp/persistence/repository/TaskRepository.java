package com.example.todoapp.persistence.repository;

import com.example.todoapp.persistence.entity.Task;
import com.example.todoapp.persistence.entity.TaskStatus;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface TaskRepository extends JpaRepository<Task, Long> {
    List<Task> findAllByStatus(TaskStatus status);
    @Modifying
    @Query(value = "UPDATE Task t SET t.status = 'DONE' WHERE t.id = :id", nativeQuery = true)
    public void markTaskAsDone(@Param("id") Long id);
}
