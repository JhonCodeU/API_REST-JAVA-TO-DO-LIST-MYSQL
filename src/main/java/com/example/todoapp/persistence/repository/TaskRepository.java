package com.example.todoapp.persistence.repository;

import com.example.todoapp.persistence.entity.Task;
import com.example.todoapp.persistence.entity.TaskStatus;
import jakarta.transaction.Transactional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface TaskRepository extends JpaRepository<Task, Long> {
    List<Task> findAllByStatus(TaskStatus status);

    @Transactional
    @Modifying
    @Query(value = "UPDATE Task t SET t.status = :status WHERE t.id = :id")
    void markTaskAsDone(@Param("id") Long id, @Param("status") TaskStatus status);
}
