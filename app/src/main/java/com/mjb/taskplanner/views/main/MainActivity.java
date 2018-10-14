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
    FloatingActionButton fabButton;

    private BottomNavigationView.OnNavigationItemSelectedListener mOnNavigationItemSelectedListener
            = new BottomNavigationView.OnNavigationItemSelectedListener() {

        @Override
        public boolean onNavigationItemSelected(@NonNull MenuItem item) {
            TaskListFragment fragment = null;
            switch (item.getItemId()) {
                case R.id.navigation_todo:
                    fragment = TaskListFragment.newInstance();
                    replaceFragment(fragment);
                    return true;
                case R.id.navigation_today:
                    fragment = TaskListFragment.newInstance();
                    replaceFragment(fragment);
                    return true;
                case R.id.navigation_priority:
                    fragment = TaskListFragment.newInstance();
                    replaceFragment(fragment);
                    return true;
                case R.id.navigation_done:
                    fragment = TaskListFragment.newInstance();
                    replaceFragment(fragment);
                    return true;
                case R.id.navigation_expired:
                    fragment = TaskListFragment.newInstance();
                    replaceFragment(fragment);
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
    public void fabClicked(){
        Log.i(TAG, "Pulsado FAB button");
    }

    @Override
    public void updateToolbarTitle(int titleId) {
        toolbar.setTitle(titleId);
    }
}
