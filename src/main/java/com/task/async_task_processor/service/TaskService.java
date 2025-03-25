package com.task.async_task_processor.service;

import com.task.async_task_processor.entity.Task;
import com.task.async_task_processor.enums.TaskStatus;
import com.task.async_task_processor.repository.TaskRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class TaskService {

    private final TaskRepository taskRepository;
    @Autowired
    private AsyncTaskProcessor asyncTaskProcessor;


    public Task submitTask(String name, String payload) {
        Task task = new Task();
        task.setName(name);
        task.setPayload(payload);
        task.setStatus(TaskStatus.PENDING);
        task.setCreatedAt(LocalDateTime.now());
        task.setUpdatedAt(LocalDateTime.now());
        task = taskRepository.save(task);
        asyncTaskProcessor.processTaskAsync(task);
        return task;
    }

    public List<Task> getAllTasks() {
        return taskRepository.findAll();
    }

    public Optional<Task> getTaskById(Long taskId) {
        return taskRepository.findById(taskId);
    }
}
