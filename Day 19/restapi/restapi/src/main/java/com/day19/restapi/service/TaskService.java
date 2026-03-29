package com.day19.restapi.service;

import com.day19.restapi.model.Task;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class TaskService {

    private List<Task> tasks = new ArrayList<>();

    public List<Task> getAllTasks() {
        return tasks;
    }

    public Task addTask(Task task) {
        tasks.add(task);
        return task;
    }
}