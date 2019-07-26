package com.shaary.todolist.model;

import android.arch.persistence.room.Room;
import android.content.Context;

import com.shaary.todolist.Database.TaskDatabase;

import java.util.List;

//Singleton
public class TasksList {
    private static TasksList sTasksList;
    private List<Task> tasks;
    private Context context;
    private TaskDatabase database;

    public static TasksList getInstance(Context context) {
        if (sTasksList == null) {
            sTasksList = new TasksList(context);
        }
        return sTasksList;
    }

    private TasksList(Context context) {
        this.context = context.getApplicationContext();
        //TODO: move to back thread
        database = Room.databaseBuilder(context, TaskDatabase.class, "task-db")
                .allowMainThreadQueries()
                .build();
        //tasks = new ArrayList<>();
    }

    public void addTask(Task task) {
        //tasks.add(task);
        database.taskDao().insert(task);
    }

    public List<Task> getTasks() {
        return database.taskDao().getAll();
    }

    public Task getTask(int id) {
        return database.taskDao().getTaskById(id);
    }

    public void deleteTaskById(int id) {
        database.taskDao().deleteTaskById(id);
    }
}
