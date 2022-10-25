package com.example.a108590033_hw4_1;

import androidx.appcompat.app.AppCompatActivity;

import android.graphics.Color;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    private int Value = 0;
    private Button Count1;
    private TextView mShowCount;
    private EditText mMessageEditText;
    private static final String LOG_TAG =
            MainActivity.class.getSimpleName();
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Count1 = (Button) findViewById(R.id.button3);
        mShowCount = (TextView) findViewById(R.id.textView2);
        mMessageEditText = (EditText) findViewById(R.id.editText_main);

        if (savedInstanceState != null) {
            String count = savedInstanceState.getString("count");
            if (mShowCount != null)
                mShowCount.setText(count);
        }
    }

    @Override
    public void onSaveInstanceState(Bundle outState) {
        super.onSaveInstanceState(outState);
        // Add information for saving HelloToast counter
        // to the to the outState bundle
        outState.putString("count", String.valueOf(mShowCount.getText()));
    }
    public void countUp(View view) {
        Value++;
        if (mShowCount != null)
            mShowCount.setText(Integer.toString(Value));
    }
    @Override
    public void onRestoreInstanceState (Bundle mySavedState) {
        super.onRestoreInstanceState(mySavedState);

        if (mySavedState != null) {
            String count = mySavedState.getString("count");
            if (count != null)
                mShowCount.setText(count);
        }
    }


    @Override
    protected void onStart() {
        super.onStart();
        Log.d(LOG_TAG, "onStart");
    }

    @Override
    protected void onPause() {
        super.onPause();
        Log.d(LOG_TAG, "onPause");
    }

    @Override
    protected void onRestart() {
        super.onRestart();
        Log.d(LOG_TAG, "onRestart");
    }

    @Override
    protected void onResume() {
        super.onResume();
        Log.d(LOG_TAG, "onResume");
    }

    @Override
    protected void onStop() {
        super.onStop();
        Log.d(LOG_TAG, "onStop");
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        Log.d(LOG_TAG, "onDestroy");
    }
}