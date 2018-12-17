package com.shaary.todolist.presenter;

import com.shaary.todolist.adapters.TasksAdapter;
import com.shaary.todolist.view.ToDoListFragmentView;

public class ToDoListFragmentPresenter {

    ToDoListFragmentView view;

    public ToDoListFragmentPresenter(ToDoListFragmentView view) {
        this.view = view;
    }

    public void setView() {
        view.updateUi();
    }
}
