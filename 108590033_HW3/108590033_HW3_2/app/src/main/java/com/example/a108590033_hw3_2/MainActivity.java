package com.example.a108590033_hw3_2;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    private static final String LOG_TAG =
            MainActivity.class.getSimpleName();

    private int Value = 0,ct=0,countup=0;
    private TextView mShowCount;
    private Button Zero1,Toast1,Count1;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        mShowCount = (TextView) findViewById(R.id.textView2);
        Zero1 = (Button) findViewById(R.id.button2);
        Toast1= (Button) findViewById(R.id.button);
        Count1 = (Button) findViewById(R.id.button3);
        Zero1.setEnabled(false);
    }

    public void launchSecondActivity(View view) {
        Intent intent = new Intent(this, MainActivity2.class);
        intent.putExtra("Value", Value);
        startActivity(intent);
        finish();

    }
    public void countUp(View view) {
        Value++;
        if (mShowCount != null)
            mShowCount.setText(Integer.toString(Value));
        if(countup%2==1){
            Count1.setBackgroundColor(Color.parseColor("#3F51B5"));}
        else{
            Count1.setBackgroundColor(Color.parseColor("#28FF28"));
        }
        countup++;
        Zero1.setBackgroundColor(Color.parseColor("#FF4081"));
        Zero1.setEnabled(true);
    }
    public void countZero(View view){
        Value = 0;
        if (mShowCount != null)
            mShowCount.setText(Integer.toString(Value));
        Zero1.setEnabled(false);
        Zero1.setBackgroundColor(Color.parseColor("#6C6C6C"));}
}