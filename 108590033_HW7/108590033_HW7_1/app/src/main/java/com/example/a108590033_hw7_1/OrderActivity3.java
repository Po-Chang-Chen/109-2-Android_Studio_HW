package com.example.a108590033_hw7_1;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

public class OrderActivity3 extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_order3);
        // Get the intent and its data.
        Intent intent2 = getIntent();
        String message = intent2.getStringExtra(MainActivity.EXTRA_MESSAGE);

    }
}