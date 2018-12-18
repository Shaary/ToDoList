package com.shaary.todolist;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;

import com.shaary.todolist.adapters.TasksAdapter;
import com.shaary.todolist.model.Task;
import com.shaary.todolist.model.TasksList;
import com.shaary.todolist.presenter.ToDoListFragmentPresenter;
import com.shaary.todolist.view.ToDoListFragmentView;

import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;


/**
 * A simple {@link Fragment} subclass.
 */
public class ToDoListFragment extends Fragment implements ToDoListFragmentView, TasksAdapter.Listener {

    private static final String TAG = ToDoListFragment.class.getSimpleName();
    @BindView(R.id.recycler_view) RecyclerView recyclerView;
    private TasksAdapter adapter;
    private ToDoListFragmentPresenter presenter;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        Log.d(TAG, "onCreateView: is called");

        View view = inflater.inflate(R.layout.fragment_to_do_list, container, false);
        ButterKnife.bind(this, view);
        setHasOptionsMenu(true);

        LinearLayoutManager lm = new LinearLayoutManager(getContext());
        lm.setOrientation(LinearLayoutManager.VERTICAL);
        recyclerView.setLayoutManager(lm);

        adapter = new TasksAdapter(this);
        recyclerView.setAdapter(adapter);

        presenter = new ToDoListFragmentPresenter(this);

        return view;
    }

    @Override
    public void onCreateOptionsMenu(Menu menu, MenuInflater inflater) {
        super.onCreateOptionsMenu(menu, inflater);
        inflater.inflate(R.menu.tasks_list, menu);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {

        switch (item.getItemId()) {
            case R.id.add_task:
                //Creates a new task and opens the Task Fragment with the task's id to save changes to the task
                Task task = new Task();
                TasksList.getInstance().addTask(task);
                TaskFragment taskFragment = new TaskFragment().newInstance(task.getId());

                getFragmentManager().beginTransaction()
                        .replace(R.id.container_layout, taskFragment, "taskFrag")
                        .addToBackStack(null)
                        .commit();
                return true;
            default:
                return super.onOptionsItemSelected(item);
        }
    }

    @Override
    public void onResume() {
        super.onResume();
        presenter.setView();
    }

    @Override
    public void updateUi() {
        TasksList tasksList = TasksList.getInstance();
        List<Task> list = tasksList.getTasks();

        adapter.setTasks(list);
        adapter.notifyDataSetChanged();
    }

    @Override
    public void onTaskSelected(Task task) {
        TaskFragment taskFragment = new TaskFragment().newInstance(task.getId());

        getFragmentManager().beginTransaction()
                .replace(R.id.container_layout, taskFragment, "taskFrag")
                .addToBackStack(null)
                .commit();

    }
}
