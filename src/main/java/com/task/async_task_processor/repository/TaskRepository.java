package com.task.async_task_processor.repository;


import com.task.async_task_processor.entity.Task;
import org.springframework.data.jpa.repository.JpaRepository;
public interface TaskRepository extends JpaRepository<Task, Long> {
}
