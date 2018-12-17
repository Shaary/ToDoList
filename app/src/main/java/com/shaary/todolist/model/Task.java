package com.shaary.todolist.model;

import java.util.Date;
import java.util.UUID;

public class Task {
    private String name;
    private String description;
    private Date dueDate;
    private String category;
    private UUID id;
    private boolean done;

    public Task() {
        this.id = UUID.randomUUID();
        dueDate = new Date();
    }

    //To restore from database
    public Task(UUID id) {
        this.id = id;
        dueDate = new Date();
    }

    public UUID getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Date getDueDate() {
        return dueDate;
    }

    public void setDueDate(Date dueDate) {
        this.dueDate = dueDate;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public boolean getDone() {
        return done;
    }

    public void setDone(boolean done) {
        this.done = done;
    }
}
