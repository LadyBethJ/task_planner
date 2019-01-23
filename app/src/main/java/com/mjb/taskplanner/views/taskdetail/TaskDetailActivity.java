package com.mjb.taskplanner.views.taskdetail;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.widget.TextView;

import com.mjb.taskplanner.R;
import com.mjb.taskplanner.utils.Utils;

import butterknife.BindView;
import butterknife.ButterKnife;

public class TaskDetailActivity extends AppCompatActivity implements TaskDetailView {

    private static final String TAG = TaskDetailActivity.class.getSimpleName();

    private TaskDetailPresenter presenter;

    @BindView(R.id.toolbar)
    Toolbar toolbar;

    @BindView(R.id.task_name)
    TextView tvName;

    @BindView(R.id.task_date)
    TextView tvDate;

    @BindView(R.id.task_hour)
    TextView tvHour;

    @BindView(R.id.task_prior)
    TextView tvPrior;

    @BindView(R.id.task_list)
    TextView tvList;

    @BindView(R.id.task_father)
    TextView tvFather;

    @BindView(R.id.task_notes)
    TextView tvNotes;

    //TODO cambiar por un imageView
    @BindView(R.id.task_photo)
    TextView tvPhoto;

    //TODO cambiar por un checkbox
    @BindView(R.id.task_done)
    TextView tvDone;

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

            //TODO actualizar codigo cuando BBDD lista
            updateUI(getIntent().getStringExtra("NAME"), getIntent().getStringExtra("LIST"), getIntent().getStringExtra("DATE"), getIntent().getStringExtra("HOUR"));
        }
    }

    private void updateUI(String name, String list, String date, String hour){
        if (Utils.isNotNullNorEmpty(name)) {
            tvName.setText(name);
        } else {
            tvName.setText(getText(R.string.no_name));
        }

        if (Utils.isNotNullNorEmpty(list)) {
            tvList.setText(list);
        } else {
            tvList.setText(getText(R.string.no_list));
        }

        if (Utils.isNotNullNorEmpty(date)) {
            tvDate.setText(date);
        } else {
            tvDate.setText(getText(R.string.no_date));
        }

        if (Utils.isNotNullNorEmpty(hour)) {
            tvHour.setText(hour);
        } else {
            tvHour.setText(getText(R.string.no_hour));
        }

        tvPrior.setText(getText(R.string.no_prior));
        tvFather.setText(getText(R.string.no_father));
        tvNotes.setText(getText(R.string.no_notes));
        tvPhoto.setText(getText(R.string.no_photo));
        tvDone.setText(getText(R.string.not_done));
    }
}
