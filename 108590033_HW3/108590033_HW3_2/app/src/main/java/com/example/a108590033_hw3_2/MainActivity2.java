package com.example.a108590033_hw3_2;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity2 extends AppCompatActivity {
    private TextView mShowCount;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);

        Bundle bundle = getIntent().getExtras();
        Integer intent = bundle.getInt("Value");
        mShowCount = (TextView) findViewById(R.id.textView2);
        if (mShowCount != null)
            mShowCount.setText(Integer.toString(intent));
    }
}