package com.sahgal.taskmanager.helper;

import org.springframework.stereotype.Component;

@Component
public class TaskHelper {

    public String formatTitle(String title) {
        return title.toUpperCase();
    }
}