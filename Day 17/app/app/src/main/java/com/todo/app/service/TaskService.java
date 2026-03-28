package com.todo.app.service;

import com.todo.app.model.Task;
import com.todo.app.repository.TaskRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TaskService {

    private final TaskRepository repo;

    public TaskService(TaskRepository repo) {
        this.repo = repo;
    }

    public Task addTask(Task task) {
        return repo.save(task);
    }

    public List<Task> getAll() {
        return repo.findAll();
    }

    public void delete(Long id) {
        repo.deleteById(id);
    }

    public Task markComplete(Long id) {
        Task t = repo.findById(id)
                .orElseThrow(() -> new RuntimeException("Task not found"));
        t.setCompleted(true);
        return repo.save(t);
    }
}