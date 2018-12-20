package com.shaary.todolist.Database;

import android.arch.persistence.room.Database;
import android.arch.persistence.room.RoomDatabase;
import android.arch.persistence.room.TypeConverters;

import com.shaary.todolist.model.Task;

@Database(entities = {Task.class}, version = 1)
@TypeConverters({UuidConverter.class, DateConverter.class})
public abstract class TaskDatabase extends RoomDatabase {
    public abstract TaskDao taskDao();
}
