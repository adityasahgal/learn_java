package com.todo.app.controller;

import com.todo.app.model.Task;
import com.todo.app.service.TaskService;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.todo.app.dto.ApiResponse;
import java.util.List;

@RestController
@RequestMapping("/api/tasks")
public class TaskController {

    private final TaskService service;

    public TaskController(TaskService service) {
        this.service = service;
    }

    @PostMapping
    public ResponseEntity<ApiResponse> add(@RequestBody Task task) {
        Task saved = service.addTask(task);
        return ResponseEntity.status(201)
                .body(new ApiResponse("Task Added Successfully", saved));
    }

    @GetMapping
    public List<Task> getAll() {
        return service.getAll();
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable Long id) {
        service.delete(id);
    }

    @PutMapping("/{id}/complete")
    public Task complete(@PathVariable Long id) {
        return service.markComplete(id);
    }
}