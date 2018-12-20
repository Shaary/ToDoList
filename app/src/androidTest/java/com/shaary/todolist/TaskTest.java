package com.shaary.todolist;

import android.arch.persistence.room.Room;
import android.content.Context;
import android.support.test.InstrumentationRegistry;
import android.support.test.runner.AndroidJUnit4;

import com.shaary.todolist.Database.TaskDatabase;
import com.shaary.todolist.model.Task;

import org.junit.Test;
import org.junit.runner.RunWith;

import java.util.List;
import java.util.UUID;

import static org.junit.Assert.*;


@RunWith(AndroidJUnit4.class)
public class TaskTest {
    private Task task = new Task(0);
    @Test
    public void taskTest() {
        Context appContext = InstrumentationRegistry.getTargetContext();
        TaskDatabase db = Room.databaseBuilder(appContext, TaskDatabase.class, "task-db").build();
        db.taskDao().insert(task);
        Task returnedTask = db.taskDao().getTaskById(task.getId());
        assertEquals(task, returnedTask);
    }
}
