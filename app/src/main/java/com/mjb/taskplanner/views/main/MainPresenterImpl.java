package com.mjb.taskplanner.views.main;

import android.content.Context;

import javax.inject.Inject;

public class MainPresenterImpl implements MainPresenter {

    private MainView view;
    private MainInteractor interactor;

    @Inject
    Context context;

    public MainPresenterImpl(MainView view) {
        this.view = view;
        interactor = new MainInteractorImpl();
    }
}
