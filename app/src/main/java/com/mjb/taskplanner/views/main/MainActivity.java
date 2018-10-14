package com.mjb.taskplanner.views.main;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.design.widget.BottomNavigationView;
import android.support.design.widget.FloatingActionButton;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.MenuItem;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.mjb.taskplanner.R;
import com.mjb.taskplanner.views.list.TaskListFragment;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class MainActivity extends AppCompatActivity implements MainView {

    private static final String TAG = MainActivity.class.getSimpleName();

    private MainPresenter presenter;

    @BindView(R.id.toolbar)
    Toolbar toolbar;
    @BindView(R.id.fab_btn)
    FloatingActionButton fabBtn;
    @BindView(R.id.fab_new_task)
    LinearLayout fabNewTaskBtn;
    @BindView(R.id.fab_new_list)
    LinearLayout fabNewListBtn;

    private BottomNavigationView.OnNavigationItemSelectedListener mOnNavigationItemSelectedListener
            = new BottomNavigationView.OnNavigationItemSelectedListener() {

        @Override
        public boolean onNavigationItemSelected(@NonNull MenuItem item) {
            TaskListFragment fragment = null;
            switch (item.getItemId()) {
                case R.id.navigation_todo:
                    fragment = TaskListFragment.newInstance();
                    replaceFragment(fragment);
                    hideFABs();
                    return true;
                case R.id.navigation_today:
                    fragment = TaskListFragment.newInstance();
                    replaceFragment(fragment);
                    hideFABs();
                    return true;
                case R.id.navigation_priority:
                    fragment = TaskListFragment.newInstance();
                    replaceFragment(fragment);
                    hideFABs();
                    return true;
                case R.id.navigation_done:
                    fragment = TaskListFragment.newInstance();
                    replaceFragment(fragment);
                    hideFABs();
                    return true;
                case R.id.navigation_expired:
                    fragment = TaskListFragment.newInstance();
                    replaceFragment(fragment);
                    hideFABs();
                    return true;
            }
            return false;
        }
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        ButterKnife.bind(this);

        presenter = new MainPresenterImpl(this);

        setSupportActionBar(toolbar);

        BottomNavigationView navigation = (BottomNavigationView) findViewById(R.id.navigation);
        navigation.setOnNavigationItemSelectedListener(mOnNavigationItemSelectedListener);

        replaceFragment(TaskListFragment.newInstance());
    }

    private void replaceFragment(Fragment fragment) {
        FragmentTransaction fragmentTransaction = getSupportFragmentManager().beginTransaction();
        fragmentTransaction.replace(R.id.fragment_container, fragment);
        fragmentTransaction.commit();
    }

    @OnClick(R.id.fab_btn)
    public void fabMainClicked(){
        updateFABVisibility(fabNewTaskBtn, fabNewTaskBtn.getVisibility());
        updateFABVisibility(fabNewListBtn, fabNewListBtn.getVisibility());
    }

    @OnClick(R.id.fab_new_task)
    public void fabNewTaskClicked(){
        Log.i(TAG, "Pulsado FAB nueva tarea");
    }
    @OnClick(R.id.fab_new_list)
    public void fabNewListClicked(){
        Log.i(TAG, "Pulsado FAB nueva lista");
    }

    @Override
    public void updateToolbarTitle(int titleId) {
        toolbar.setTitle(titleId);
    }

    private void updateFABVisibility(View fabView, int visibility){
        switch (visibility){
            case View.GONE:
                fabView.setVisibility(View.VISIBLE);
                break;
            case View.VISIBLE:
                fabView.setVisibility(View.GONE);
                break;
        }
    }

    private void hideFABs() {
        fabNewListBtn.setVisibility(View.GONE);
        fabNewTaskBtn.setVisibility(View.GONE);
    }
}
