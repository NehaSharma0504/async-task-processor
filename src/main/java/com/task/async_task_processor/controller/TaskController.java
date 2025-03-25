package com.task.async_task_processor.controller;

import com.task.async_task_processor.entity.Task;
import com.task.async_task_processor.service.TaskService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/tasks")
@RequiredArgsConstructor
public class TaskController {

    private final TaskService taskService;

    @PostMapping("/submit")
    public Task submitTask(@RequestParam String name, @RequestParam String payload) {
        return taskService.submitTask(name, payload);
    }

    @GetMapping
    public List<Task> getAllTasks() {
        return taskService.getAllTasks();
    }

    @GetMapping("/{id}")
    public Optional<Task> getTaskStatus(@PathVariable Long id) {
        return taskService.getTaskById(id);
    }
}
