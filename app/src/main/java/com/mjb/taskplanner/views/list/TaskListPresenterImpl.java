package com.mjb.taskplanner.views.list;

import android.content.Context;

import javax.inject.Inject;

public class TaskListPresenterImpl implements TaskListPresenter {

    private TaskListView view;
    private TaskListInteractor interactor;

    @Inject
    Context context;

    public TaskListPresenterImpl(TaskListView view) {
        this.view = view;
        interactor = new TaskListInteractorImpl();
    }
}
