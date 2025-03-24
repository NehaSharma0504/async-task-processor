package com.task.async_task_processor;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableAsync;

@SpringBootApplication
@EnableAsync
public class AsyncTaskProcessorApplication {

	public static void main(String[] args) {
		SpringApplication.run(AsyncTaskProcessorApplication.class, args);
	}

}
