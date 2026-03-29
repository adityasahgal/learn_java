package com.day19.restapi.controller;

import com.day19.restapi.model.Task;
import com.day19.restapi.service.TaskService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/tasks")
public class TaskController {

    private final TaskService service;

    public TaskController(TaskService service) {
        this.service = service;
    }

    // GET API
    @GetMapping
    public List<Task> getTasks() {
        return service.getAllTasks();
    }

    // POST API
    @PostMapping
    public Task addTask(@RequestBody Task task) {
        return service.addTask(task);
    }
}