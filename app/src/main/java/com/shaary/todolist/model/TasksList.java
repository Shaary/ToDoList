package com.shaary.todolist.model;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

//Singleton
public class TasksList {
    private static TasksList sTasksList;
    private List<Task> tasks;

    public static TasksList getInstance() {
        if (sTasksList == null) {
            sTasksList = new TasksList();
        }
        return sTasksList;
    }

    private TasksList() {
        tasks = new ArrayList<>();
    }

    public void addTask(Task task) {
        tasks.add(task);
    }

    public List<Task> getTasks() {
        return tasks;
    }

    public Task getTask(UUID id) {
        for (Task t : tasks) {
            if (t.getId() == id) {
                return t;
            }
        }
        return null;
    }
}
