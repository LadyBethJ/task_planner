package com.mjb.taskplanner.core;

import android.content.Context;

import dagger.Module;
import dagger.Provides;

@Module
public class TaskPlannerApplicationModule {

    @Provides
    Context provideContext(TaskPlannerApplication application) {
        return application.getApplicationContext();

    }
}
