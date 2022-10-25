package com.example.a108590033_hw8_1;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;

public class MainActivity extends AppCompatActivity {
    private ImageView img;
    private int level = -1;
    private Button btn1,btn2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        img = (ImageView)findViewById(R.id.imageView);
        btn1 = (Button)findViewById(R.id.button);
        btn2 = (Button)findViewById(R.id.button2);
        btn1.setEnabled(false);
    }

    public void up(View view){
        btn1.setEnabled(true);
        if(level<5){
            level++;
            img.setImageLevel(level);
        }else{
            btn2.setEnabled(false);
        }
    }

    public void down(View view){
        btn2.setEnabled(true);
        if(level>0){
            level--;
            img.setImageLevel(level);
        }else{
            btn1.setEnabled(false);
        }
    }
}