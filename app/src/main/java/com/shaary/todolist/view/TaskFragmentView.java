package com.shaary.todolist.view;

import java.util.Date;

public interface TaskFragmentView {
    void setTask(String task);
    void setDescription(String desc);
    void setDate();
    void checkDone(boolean isChecked);
}
