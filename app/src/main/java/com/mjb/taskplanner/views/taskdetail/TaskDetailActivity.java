package com.mjb.taskplanner.views.taskdetail;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.util.Log;

import com.mjb.taskplanner.R;

import butterknife.BindView;
import butterknife.ButterKnife;

public class TaskDetailActivity extends AppCompatActivity implements TaskDetailView {

    private static final String TAG = TaskDetailActivity.class.getSimpleName();

    private TaskDetailPresenter presenter;

    @BindView(R.id.toolbar)
    Toolbar toolbar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_task_detail);

        ButterKnife.bind(this);

        //presenter = new TaskDetailPresenterImpl(this);

        setSupportActionBar(toolbar);

        getIncomingIntent();
    }

    private void getIncomingIntent() {
        Log.d(TAG, "getIncomingIntent: checking for incoming intents.");

        //TODO cuando BBDD ready obtener el id de la tarea, ahora pasamos todo
        if(getIntent().hasExtra("NAME") && getIntent().hasExtra("LIST")
                && getIntent().hasExtra("DATE") && getIntent().hasExtra("HOUR")) {
            Log.d(TAG, "getIncomingIntent: incoming intent with data!");
        }
    }
}
