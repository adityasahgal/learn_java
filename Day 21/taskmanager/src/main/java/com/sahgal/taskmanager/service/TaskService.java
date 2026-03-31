package com.sahgal.taskmanager.service;

import com.sahgal.taskmanager.helper.TaskHelper;
import com.sahgal.taskmanager.model.Task;
import com.sahgal.taskmanager.repository.TaskRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TaskService {

    @Autowired
    private TaskRepository repository;

    @Autowired
    private TaskHelper helper; // 👈 injected

    public Task addTask(Task task) {

        // use helper
        String formattedTitle = helper.formatTitle(task.getTitle());
        task.setTitle(formattedTitle);

        return repository.save(task);
    }

    public List<Task> getAllTasks() {
        return repository.findAll();
    }
}