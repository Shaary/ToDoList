package com.shaary.todolist.adapters;

import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.shaary.todolist.R;
import com.shaary.todolist.model.Task;
import com.shaary.todolist.presenter.TaskAdapterPresenter;
import com.shaary.todolist.view.TaskViewHolderView;

import java.util.List;

public class TasksAdapter extends RecyclerView.Adapter<TasksAdapter.TaskViewHolder> {


    private TaskAdapterPresenter presenter;

    public TasksAdapter() {
        presenter = new TaskAdapterPresenter();
    }

    @NonNull
    @Override
    public TaskViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater inflater = LayoutInflater.from(parent.getContext());

        View view = inflater.inflate(R.layout.list_item_task, parent, false);

        return new TaskViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull TaskViewHolder holder, int position) {
        presenter.bindView(holder, position);
    }

    @Override
    public int getItemCount() {
        return presenter.getListSize();
    }

    public void setTasks(List<Task> tasks) {
        presenter.setTasks(tasks);
    }

    class TaskViewHolder extends RecyclerView.ViewHolder implements TaskViewHolderView {

        TextView taskName;
        TextView dueDate;


        public TaskViewHolder(View itemView) {
            super(itemView);
            taskName = itemView.findViewById(R.id.task_title_text);
            dueDate = itemView.findViewById(R.id.due_date_text);
        }

        @Override
        public void bind(Task task) {
            taskName.setText(task.getName());
            dueDate.setText(task.getDueDate().toString());
        }
    }
}
