package com.application.circularrecyclerview;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.os.Handler;

public class MainActivity extends AppCompatActivity {

    private RecyclerView rvItems;
    private int NO_OF_ITEMS = 3;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initViews();
        initRecyclerView();
    }

    private void initRecyclerView() {
        rvItems.setLayoutManager(new LinearLayoutManager(MainActivity.this,LinearLayoutManager.HORIZONTAL,false));
        rvItems.setAdapter(new Adapter_item(NO_OF_ITEMS));
        startRotating();
    }

    private void initViews() {
        rvItems = findViewById(R.id.activity_main_rv);
    }

    public void startRotating() {
        final Handler handler = new Handler();
        final Runnable runnable = new Runnable() {
            @Override
            public void run() {
                //vary x value to change speed of rotation
                rvItems.scrollBy(3, 0);
                handler.postDelayed(this, 0);
            }
        };
        handler.postDelayed(runnable, 0);
    }
}