package com.task.async_task_processor.service;

import com.task.async_task_processor.entity.Task;
import com.task.async_task_processor.enums.TaskStatus;
import com.task.async_task_processor.repository.TaskRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;

@Service
public class AsyncTaskProcessor {
    @Autowired
    private TaskRepository taskRepository;

    @Async
    public void processTaskAsync(Task task) {
        try {
            task.setStatus(TaskStatus.PROCESSING);
            task.setUpdatedAt(LocalDateTime.now());
            taskRepository.save(task);

            // Simulate time-consuming processing
            Thread.sleep(5000);

            task.setStatus(TaskStatus.COMPLETED);
        } catch (Exception e) {
            task.setStatus(TaskStatus.FAILED);
        } finally {
            task.setUpdatedAt(LocalDateTime.now());
            taskRepository.save(task);
        }
    }
}