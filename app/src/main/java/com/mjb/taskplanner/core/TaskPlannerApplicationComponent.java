package com.mjb.taskplanner.core;

import javax.inject.Singleton;

import dagger.BindsInstance;
import dagger.Component;

@Singleton
@Component(modules = {
        /* Use AndroidInjectionModule.class if you're not using support library
        AndroidSupportInjectionModule.class,*/
        TaskPlannerApplicationModule.class,
        BuildersModule.class
})
public interface TaskPlannerApplicationComponent {
    @Component.Builder
    interface Builder {
        @BindsInstance
        Builder application(TaskPlannerApplication application);
        TaskPlannerApplicationComponent build();
    }
    void inject(TaskPlannerApplication app);
}