package com.mjb.taskplanner.views.main;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.design.widget.BottomNavigationView;
import android.support.v7.app.AppCompatActivity;
import android.view.MenuItem;
import android.widget.TextView;

import com.mjb.taskplanner.R;

public class MainActivity extends AppCompatActivity {

    private TextView mTextMessage;

    private BottomNavigationView.OnNavigationItemSelectedListener mOnNavigationItemSelectedListener
            = new BottomNavigationView.OnNavigationItemSelectedListener() {

        @Override
        public boolean onNavigationItemSelected(@NonNull MenuItem item) {
            switch (item.getItemId()) {
                case R.id.navigation_todo:
                    mTextMessage.setText(R.string.title_todo);
                    return true;
                case R.id.navigation_today:
                    mTextMessage.setText(R.string.title_today);
                    return true;
                case R.id.navigation_priority:
                    mTextMessage.setText(R.string.title_priority);
                    return true;
                case R.id.navigation_done:
                    mTextMessage.setText(R.string.title_done);
                    return true;
                case R.id.navigation_expired:
                    mTextMessage.setText(R.string.title_expired);
                    return true;
            }
            return false;
        }
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mTextMessage = (TextView) findViewById(R.id.message);
        BottomNavigationView navigation = (BottomNavigationView) findViewById(R.id.navigation);
        navigation.setOnNavigationItemSelectedListener(mOnNavigationItemSelectedListener);
    }

}
