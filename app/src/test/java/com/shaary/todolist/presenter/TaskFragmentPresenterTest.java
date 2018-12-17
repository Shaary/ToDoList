package com.shaary.todolist.presenter;

import com.shaary.todolist.view.TaskFragmentView;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.MockitoJUnitRunner;

import static org.junit.Assert.*;

@RunWith(MockitoJUnitRunner.class)
public class TaskFragmentPresenterTest {

    TaskFragmentPresenter presenter;

    @Mock
    TaskFragmentView view;

    @Before
    public void setUp() throws Exception {

        presenter = new TaskFragmentPresenter(view);
    }

    @Test
    public void setTaskName() {
        //Arrange
        String givenString = "test";

        //Act
        presenter.setTaskName(givenString);

        //Assert
        Mockito.verify(view).setTask(givenString);

    }

    @Test
    public void setDescriptionText() {
        //Arrange
        String givenString = "test";

        //Act
        presenter.setDescriptionText(givenString);

        //Assert
        Mockito.verify(view).setDescription(givenString);
    }

    @Test
    public void setDateButton() {
        presenter.setDateButton();

        Mockito.verify(view).setDate();
    }

    @Test
    public void setDoneBox() {
        //Arrange
        boolean b = true;

        //Act
        presenter.setDoneBox(b);

        //Assert
        Mockito.verify(view).checkDone(b);
    }
}