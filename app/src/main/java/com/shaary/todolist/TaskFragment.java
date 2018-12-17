package com.shaary.todolist;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.text.Editable;
import android.text.TextWatcher;
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
import java.util.UUID;

import butterknife.BindView;
import butterknife.ButterKnife;


/**
 * A simple {@link Fragment} subclass.
 */
public class TaskFragment extends Fragment implements TaskFragmentView{

    private static final String TASK_ID = "task_id";
    @BindView(R.id.name_edit_text) EditText taskText;
    @BindView(R.id.desc_edit_text) EditText descText;
    @BindView(R.id.done_box) CheckBox doneBox;
    @BindView(R.id.date_button) Button dateButton;

    private Task task;

    private TaskFragmentPresenter presenter;

    public static TaskFragment newInstance(UUID taskId) {
        Bundle args = new Bundle();
        args.putSerializable(TASK_ID, taskId);

        TaskFragment fragment = new TaskFragment();
        fragment.setArguments(args);
        return fragment;
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_task, container, false);
        ButterKnife.bind(this, view);

        UUID taskId = (UUID) getArguments().getSerializable(TASK_ID);
        task = TasksList.getInstance().getTask(taskId);

        presenter = new TaskFragmentPresenter(this);

        taskText.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {

            }

            @Override
            public void afterTextChanged(Editable s) {

            }
        });

        descText.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
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

        presenter.setDateButton();

        return view;
    }

    @Override
    public void setTask(String task) {
        this.task.setName(task);
    }

    @Override
    public void setDescription(String desc) {
        descText.setText(desc);
    }

    @Override
    public void setDate() {
        dateButton.setText(R.string.set_date_text);
    }

    @Override
    public void checkDone(boolean isChecked) {
        doneBox.setChecked(isChecked);
    }

    @Override
    public void onCreateOptionsMenu(Menu menu, MenuInflater inflater) {
        super.onCreateOptionsMenu(menu, inflater);
    }


}
