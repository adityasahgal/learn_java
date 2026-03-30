package com.sahgal.taskmanager.controller;

import com.sahgal.taskmanager.model.Task;
import com.sahgal.taskmanager.service.TaskService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/tasks")
public class TaskController {

    @Autowired
    private TaskService service;

    @PostMapping
    public Task add(@RequestBody Task task) {
        return service.addTask(task);
    }

    @GetMapping
    public List<Task> getAll() {
        return service.getAllTasks();
    }
}