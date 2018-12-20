package com.shaary.todolist.Database;

import android.arch.persistence.room.Dao;
import android.arch.persistence.room.Insert;
import android.arch.persistence.room.OnConflictStrategy;
import android.arch.persistence.room.Query;

import com.shaary.todolist.model.Task;

import java.util.List;
import java.util.UUID;

@Dao
public interface TaskDao {
    @Query("select * from task")
    List<Task> getAll();

    @Query("select * from task where id = :id")
    Task getTaskById(int id);

    @Insert (onConflict = OnConflictStrategy.REPLACE)
    void insert(Task task);

    @Query("delete from task where id = :id")
    void deleteTaskById(int id);
}
