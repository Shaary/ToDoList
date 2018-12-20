package com.shaary.todolist;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.text.Editable;
import android.text.TextWatcher;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.EditText;

import com.shaary.todolist.model.Task;
import com.shaary.todolist.model.TasksList;
import com.shaary.todolist.presenter.TaskFragmentPresenter;
import com.shaary.todolist.view.TaskFragmentView;

import java.util.Date;

import butterknife.BindView;
import butterknife.ButterKnife;


/**
 * A simple {@link Fragment} subclass.
 */
public class TaskFragment extends Fragment implements TaskFragmentView{

    public static final String TAG = TaskFragment.class.getSimpleName();
    private static final String TASK_ID = "task_id";
    @BindView(R.id.name_edit_text) EditText taskName;
    @BindView(R.id.desc_edit_text) EditText taskDesc;
    @BindView(R.id.done_box) CheckBox doneBox;
    @BindView(R.id.date_button) Button dateButton;
    @BindView(R.id.save_button) Button saveButton;

    private Task task;

    private TaskFragmentPresenter presenter;

    public static TaskFragment newInstance(int taskId) {
        Bundle args = new Bundle();
        args.putInt(TASK_ID, taskId);

        TaskFragment fragment = new TaskFragment();
        fragment.setArguments(args);
        return fragment;
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_task, container, false);
        ButterKnife.bind(this, view);
        presenter = new TaskFragmentPresenter(this);

        if (getArguments() != null) {
            int taskId = getArguments().getInt(TASK_ID);
            Log.d(TAG, "onCreateView: task id " + taskId);
            task = TasksList.getInstance(getContext()).getTask(taskId);
            Log.d(TAG, "onCreateView: id after get task " + task.getId());
            presenter.setUi(task);
        } else {
            //Creates a new task and opens the Task Fragment with the task's id to save changes to the task
            task = new Task();
        }

        taskName.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
                presenter.setTaskName(s.toString());
            }

            @Override
            public void afterTextChanged(Editable s) {

            }
        });

        taskDesc.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
                presenter.setDescriptionText(s.toString());
            }

            @Override
            public void afterTextChanged(Editable s) {

            }
        });

        doneBox.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                presenter.setDoneBox(isChecked);
            }
        });

        saveButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //Saves task in a database
                TasksList.getInstance(getContext()).addTask(task);
            }
        });

        presenter.setDateButton();

        return view;
    }

    //TODO: Make the names appropriate make a save method separate from view setters

    @Override
    public void setTaskName(String taskName) {
        task.setName(taskName);
    }

    @Override
    public void setDescription(String desc) {
        task.setDescription(desc);
    }

    @Override
    public void setDate() {
        dateButton.setText(new Date().toString());
    }

    @Override
    public void checkDone(boolean isChecked) {
        doneBox.setChecked(isChecked);
    }

    @Override
    public void setUi(Task task) {
        Log.d(TAG, "setUi: was called " + task.getName());
        taskName.setText(task.getName());
        taskDesc.setText(task.getDescription());
        doneBox.setChecked(task.getDone());
        dateButton.setText(task.getDueDate().toString());

    }

    @Override
    public void onCreateOptionsMenu(Menu menu, MenuInflater inflater) {
        super.onCreateOptionsMenu(menu, inflater);
    }


}
