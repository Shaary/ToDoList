package com.shaary.todolist.view;

import com.shaary.todolist.model.Task;

import java.util.Date;

public interface TaskFragmentView {
    void setTaskName(String taskName);
    void setDescription(String desc);
    void setDate();
    void checkDone(boolean isChecked);
    void setUi(Task task);
}
