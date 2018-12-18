package com.shaary.todolist.presenter;

import com.shaary.todolist.model.Task;
import com.shaary.todolist.model.TasksList;
import com.shaary.todolist.view.TaskViewHolderView;

import java.util.List;

public class TaskAdapterPresenter {

    List<Task> list = TasksList.getInstance().getTasks();

    public void bindView(TaskViewHolderView view, int position) {
        view.bind(list.get(position));
    }

    public int getListSize() {
        return list.size();
    }

    public void setTasks(List<Task> tasks) {
        list = tasks;
    }

}
