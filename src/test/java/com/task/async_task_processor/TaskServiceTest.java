package com.task.async_task_processor;

import com.task.async_task_processor.entity.Task;
import com.task.async_task_processor.enums.TaskStatus;
import com.task.async_task_processor.repository.TaskRepository;
import com.task.async_task_processor.service.TaskService;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.springframework.boot.test.context.SpringBootTest;
import java.util.Optional;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.*;

@SpringBootTest
public class TaskServiceTest {

    @Mock
    private TaskRepository taskRepository;

    @InjectMocks
    private TaskService taskService;

    @Test
    public void testGetTaskById() {
        Task task = new Task();
        task.setId(1L);
        task.setName("Sample Task");
        task.setPayload("Payload");
        task.setStatus(TaskStatus.PENDING);

        when(taskRepository.findById(1L)).thenReturn(Optional.of(task));

        Optional<Task> result = taskService.getTaskById(1L);

        assertEquals("Sample Task", result.get().getName());
        verify(taskRepository, times(1)).findById(1L);
    }
}
