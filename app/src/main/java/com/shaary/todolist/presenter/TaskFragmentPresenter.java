package com.shaary.todolist.presenter;

import com.shaary.todolist.model.Task;
import com.shaary.todolist.view.TaskFragmentView;

import java.util.Date;

public class TaskFragmentPresenter {

    private TaskFragmentView view;

    public TaskFragmentPresenter(TaskFragmentView view) {
        this.view = view;
    }

    public void setTaskName(String name) {
        view.setTaskName(name);
    }

    public void setDescriptionText(String description) {
        view.setDescription(description);
    }

    public void setDateButton() {
        view.setDate();
    }

    public void setDoneBox(boolean isChecked) {
        view.checkDone(isChecked);
    }

    public void setUi(Task task) {
        view.setUi(task);
    }

}
